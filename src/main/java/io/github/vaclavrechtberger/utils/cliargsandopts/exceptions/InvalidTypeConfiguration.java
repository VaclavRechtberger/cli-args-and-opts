package io.github.vaclavrechtberger.utils.cliargsandopts.exceptions;

/**
 * Thrown when option type definition is wrong. Like missing, unknown or forbidden combination of config parameters.
 */
public class InvalidTypeConfiguration extends RuntimeException{
    public InvalidTypeConfiguration(Throwable cause) {
        super(cause);
    }
}
