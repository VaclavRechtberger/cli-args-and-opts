package io.github.vaclavrechtberger.utils.cliargsandopts.options.types;

/**
 * Creates type when loading config from definition file.
 */
public interface TypeFactory {
    String getTypeName();
    Type createType(Object typeConfig);
}
