package io.github.vaclavrechtberger.utils.cliargsandopts.options.types.impl;

import io.github.vaclavrechtberger.utils.cliargsandopts.options.types.Type;
import io.github.vaclavrechtberger.utils.cliargsandopts.options.types.TypeFactory;

public class EnumTypeFactory implements TypeFactory {
    @Override
    public String getTypeName() {
        return "ENUM";
    }

    @Override
    public Type createType(Object typeConfig) {
        // TODO some validity checks, unknown arguments etc.
        return new EnumType();
    }
}
