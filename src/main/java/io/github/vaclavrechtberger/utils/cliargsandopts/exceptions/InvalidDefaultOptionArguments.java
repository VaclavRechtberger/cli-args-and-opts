package io.github.vaclavrechtberger.utils.cliargsandopts.exceptions;

/**
 * Thrown when option with parameter has invalid default argument.
 */
public class InvalidDefaultOptionArguments extends RuntimeException{
    public InvalidDefaultOptionArguments() {
    }

    public InvalidDefaultOptionArguments(Throwable cause) {
        super(cause);
    }
}
