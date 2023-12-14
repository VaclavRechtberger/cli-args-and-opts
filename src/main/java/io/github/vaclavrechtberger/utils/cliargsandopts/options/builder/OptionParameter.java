package io.github.vaclavrechtberger.utils.cliargsandopts.options.builder;

public interface OptionParameter {
    OptionType withParameter();
    OptionCreator withoutParameter();
}
