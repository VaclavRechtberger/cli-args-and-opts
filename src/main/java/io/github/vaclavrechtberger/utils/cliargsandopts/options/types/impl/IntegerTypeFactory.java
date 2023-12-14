package io.github.vaclavrechtberger.utils.cliargsandopts.options.types.impl;

import io.github.vaclavrechtberger.utils.cliargsandopts.exceptions.InvalidTypeConfiguration;
import io.github.vaclavrechtberger.utils.cliargsandopts.options.types.RegisterTypeFactory;
import io.github.vaclavrechtberger.utils.cliargsandopts.options.types.Type;
import io.github.vaclavrechtberger.utils.cliargsandopts.options.types.TypeFactory;

import java.util.Map;

@RegisterTypeFactory
public class IntegerTypeFactory implements TypeFactory {
    @Override
    public String getTypeName() {
        return "INTEGER";
    }

    @Override
    public Type createType(Object typeConfig) {
        try {
            // TODO some validity checks, unknown arguments etc.
            // TODO support for boundaries
            Map<String, Object> config = (Map<String, Object>) typeConfig;
            return new IntegerType();
        } catch (ClassCastException | NullPointerException e) {
            throw new InvalidTypeConfiguration(e);
        }
    }
}
