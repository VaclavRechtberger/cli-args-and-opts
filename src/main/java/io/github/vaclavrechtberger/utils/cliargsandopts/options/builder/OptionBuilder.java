package io.github.vaclavrechtberger.utils.cliargsandopts.options.builder;

import io.github.vaclavrechtberger.utils.cliargsandopts.exceptions.InvalidOptionsConfiguration;
import io.github.vaclavrechtberger.utils.cliargsandopts.options.Option;
import io.github.vaclavrechtberger.utils.cliargsandopts.options.types.Type;

import java.util.HashSet;
import java.util.Set;

public class OptionBuilder implements
        OptionAliases,
        OptionCreator,
        OptionDefaultValue,
        OptionDescription,
        OptionMandatory,
        OptionParameter,
        OptionType {
    private Set<String> aliases = new HashSet<>();
    private String description;
    private boolean mandatory;
    private boolean withParameter;
    private boolean withDefaultValue;
    private Object defaultValue;
    private Type type;

    private OptionBuilder() {}

    public static OptionAliases createInstance() {
        return new OptionBuilder();
    }

    @Override
    public Option build() {
        return new Option(
                aliases,
                mandatory,
                description,
                withParameter,
                type,
                null,
                withDefaultValue,
                defaultValue,
                false
        );
    }

    @Override
    public OptionDescription withAliases(Set<String> aliases) {
        this.aliases = aliases;
        return this;
    }

    @Override
    public OptionParameter withDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public OptionCreator setMandatory() {
        mandatory = true;
        return this;
    }

    @Override
    public OptionDefaultValue setOptional() {
        mandatory = false;
        return this;
    }

    @Override
    public OptionType withParameter() {
        this.withParameter = true;
        return this;
    }

    @Override
    public OptionCreator withoutParameter() {
        this.withParameter = false;
        return this;
    }


    @Override
    public OptionMandatory withType(Type type) {
        this.type = type;
        return this;
    }

    @Override
    public OptionCreator withDefaultValue(Object defaultValue) {
        withDefaultValue = true;
        if (type.testRestrictions(defaultValue)) {
            this.defaultValue = defaultValue;
        } else {
            throw new InvalidOptionsConfiguration();
        }
        return this;
    }

    @Override
    public OptionCreator withoutDefaultValue() {
        withDefaultValue = false;
        return this;
    }
}
