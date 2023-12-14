package io.github.vaclavrechtberger.utils.cliargsandopts.options.builder;

public interface OptionDefaultValue {
    OptionCreator withDefaultValue(Object defaultValue);
    OptionCreator withoutDefaultValue();
}
