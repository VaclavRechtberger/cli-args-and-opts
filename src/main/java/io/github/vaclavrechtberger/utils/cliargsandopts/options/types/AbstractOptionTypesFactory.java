package io.github.vaclavrechtberger.utils.cliargsandopts.options.types;

import io.github.vaclavrechtberger.utils.cliargsandopts.exceptions.AmbiguousOption;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

import static java.util.Objects.isNull;
import static org.reflections.scanners.Scanners.TypesAnnotated;

public class AbstractOptionTypesFactory {
    private static AbstractOptionTypesFactory instance;

    private Map<String, TypeFactory> typeFactoryMap;

    private AbstractOptionTypesFactory() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        typeFactoryMap = new HashMap<>();

        loadOptionTypeFactories();
    }

    public static AbstractOptionTypesFactory getInstance() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return isNull(instance) ? instance = new AbstractOptionTypesFactory() : instance;
    }

    public Type createType(String type, Object typeConfig) {
        return typeFactoryMap.get(type).createType(typeConfig);
    }

    private void loadOptionTypeFactories() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        loadDefaultTypes();
        loadCustomTypes();
    }

    private void loadCustomTypes() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // TODO load custom packages, defined in config file as "customTypesPackages"
    }

    private void registerTypeFactory(TypeFactory typeFactory) {
        if (typeFactoryMap.containsKey(typeFactory.getTypeName())) {
            throw new AmbiguousOption();
        }
        typeFactoryMap.put(typeFactory.getTypeName(), typeFactory);
    }


    private void loadDefaultTypes() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        loadTypes("io.github.vaclavrechtberger.utils.cliargsandopts.options.types.impl");
    }

    private void loadTypes(String pkg) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Reflections reflections = new Reflections(pkg);
        Set<Class<?>> factories = reflections.get(TypesAnnotated.of(RegisterTypeFactory.class).asClass());
        for (Class<?> aClass : factories) {
            Constructor<?> ctor = aClass.getConstructor();
            TypeFactory typeFactory = (TypeFactory) ctor.newInstance();
            registerTypeFactory(typeFactory);
        }
    }
}
