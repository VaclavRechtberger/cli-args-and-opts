package io.github.vaclavrechtberger.utils.cliargsandopts.options.types.impl;

import io.github.vaclavrechtberger.utils.cliargsandopts.options.types.Type;
import io.github.vaclavrechtberger.utils.cliargsandopts.options.types.TypeFactory;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class BooleanTypeFactory implements TypeFactory {

    @Override
    public String getTypeName() {
        return "BOOLEAN";
    }

    @Override
    public Type createType(Object typeConfig) {
        throw new RuntimeException("Not implemented yet");
    }
}
