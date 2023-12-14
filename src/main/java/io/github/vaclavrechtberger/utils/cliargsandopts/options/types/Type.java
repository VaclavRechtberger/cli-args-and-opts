package io.github.vaclavrechtberger.utils.cliargsandopts.options.types;

/**
 * Type of option arguments.
 */
public interface Type {
    String getDescription();
    Object parseValue(String ... args);
    boolean testRestrictions(Object value);
}
