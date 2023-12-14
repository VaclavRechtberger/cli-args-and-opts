package io.github.vaclavrechtberger.utils.cliargsandopts.exceptions;

/**
 * Thrown when something fails during loading of options from config file.
 */
public class FailedToLoadOptions extends Exception {
    public FailedToLoadOptions(Throwable cause) {
        super(cause);
    }
}
