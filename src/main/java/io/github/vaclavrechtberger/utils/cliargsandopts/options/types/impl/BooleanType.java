package io.github.vaclavrechtberger.utils.cliargsandopts.options.types.impl;

import io.github.vaclavrechtberger.utils.cliargsandopts.options.types.Type;
import lombok.AllArgsConstructor;

import java.util.Set;

@AllArgsConstructor
public class BooleanType implements Type {
    private Set<String> trueValues;
    private Set<String> falseValues;

    @Override
    public String getDescription() {
        // TODO shall vary for parametric boolean
        return "Boolean option type values";
    }

    @Override
    public Object parseValue(String... args) {
        // TODO extend functionality for parametric boolean
        return true;
    }

    @Override
    public boolean testRestrictions(Object value) {
        throw new RuntimeException("Not implemented yet");
    }
}
