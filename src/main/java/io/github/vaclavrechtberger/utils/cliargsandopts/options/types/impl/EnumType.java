package io.github.vaclavrechtberger.utils.cliargsandopts.options.types.impl;

import io.github.vaclavrechtberger.utils.cliargsandopts.options.types.Type;

public class EnumType implements Type {
    // TODO some restriction to enum values?
    @Override
    public String getDescription() {
        return "Enum type option argument.";
    }

    @Override
    public Object parseValue(String... args) {
        return args[0];
    }

    @Override
    public boolean testRestrictions(Object value) {
        throw new RuntimeException("Not implemented yet");
    }
}
