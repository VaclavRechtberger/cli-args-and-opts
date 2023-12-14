package io.github.vaclavrechtberger.utils.cliargsandopts.options.types.impl;


import io.github.vaclavrechtberger.utils.cliargsandopts.options.types.Type;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class IntegerType implements Type {
    private Integer minValue;
    private Integer maxValue;

    @Override
    public String getDescription() {
        // shall vary for in a case of boundaries
        return "Integer option argument";
    }

    @Override
    public Object parseValue(String... args) {
        // TODO some validity checks
        return Integer.valueOf(args[0]);
    }

    @Override
    public boolean testRestrictions(Object value) {
        throw new RuntimeException("Not implemented yet");
    }
}
