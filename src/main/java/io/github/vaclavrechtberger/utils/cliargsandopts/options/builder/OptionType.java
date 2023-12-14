package io.github.vaclavrechtberger.utils.cliargsandopts.options.builder;

import io.github.vaclavrechtberger.utils.cliargsandopts.options.types.Type;

public interface OptionType {
    OptionMandatory withType(Type type);
}
