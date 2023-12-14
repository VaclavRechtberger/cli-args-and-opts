package io.github.vaclavrechtberger.utils.cliargsandopts.options;

import io.github.vaclavrechtberger.utils.cliargsandopts.exceptions.FailedToLoadOptions;
import io.github.vaclavrechtberger.utils.cliargsandopts.options.builder.OptionBuilder;
import io.github.vaclavrechtberger.utils.cliargsandopts.options.types.AbstractOptionTypesFactory;
import io.github.vaclavrechtberger.utils.cliargsandopts.options.types.Type;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

import static java.util.Objects.isNull;

public class AbstractOptionsFactory {
    /**
     * set if different file name wanted
     */
    public static String configFile = "cli-args-and-opts.yml";
    private static AbstractOptionsFactory instance;

    private Map<String, Option> optionMap;

    private AbstractOptionsFactory() throws FailedToLoadOptions {
        optionMap = new HashMap<>();
        loadOptionsFromConfig();
        initHelpIfNotExists();
    }

    public static AbstractOptionsFactory getInstance() throws FailedToLoadOptions {
        return isNull(instance) ? instance = new AbstractOptionsFactory() : instance;
    }

    public Option parseOption(String ... args) {
        Option option = optionMap.get(args[0]);
        option.setPresent(true);
        option.setValue(Arrays.copyOfRange(args, 1, args.length));
        return option;
    }

    private void initHelpIfNotExists() {
        if (!(optionMap.containsKey("-h") && (optionMap.containsKey("--help")))) {
            // TODO init help option
        }
    }

    private void loadOptionsFromConfig() throws FailedToLoadOptions {
        Yaml yaml = new Yaml();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        try (InputStream inputStream = classLoader.getResourceAsStream(configFile)) {
            Map<String, Object> config = yaml.load(inputStream);
            List<Map<String, Object>> options = (List<Map<String, Object>>) config.get("options"); // TODO catch exception here and throw more specific exception

            for (Map<String, Object> option: options) {
                initOption(option);
            }
        } catch (ClassCastException | NullPointerException | IOException | InvocationTargetException |
                 NoSuchMethodException | InstantiationException | IllegalAccessException e) {
            throw new FailedToLoadOptions(e);
        }
    }

    private void initOption(Map<String, Object> optionConfig) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // prepared only for mandatory option with INTEGER argument without any restriction
        // TODO logic to instantiate any option
        // TODO checks for wrong config like missing, unknown or wrong combination of parameters

        AbstractOptionTypesFactory abstractOptionTypesFactory = AbstractOptionTypesFactory.getInstance();
        String typeName = (String) optionConfig.get("type");
        Type type = abstractOptionTypesFactory.createType(typeName, optionConfig.get("typeConfig"));
        Boolean mandatory = (Boolean) optionConfig.get("mandatory");
        String description = (String) optionConfig.get("description");
        List<String> aliases = (List<String>) optionConfig.get("aliases");

        registerOption(
                OptionBuilder
                        .createInstance()
                        .withAliases(new HashSet<>(aliases))
                        .withDescription(description)
                        .withParameter()
                        .withType(type)
                        .setMandatory()
                        .build());
    }

    private void registerOption(Option option) {
        // TODO check for ambiguity
        option.getAliases().forEach(alias -> {
            optionMap.put(alias, option);
        });

    }
}
