package io.github.vaclavrechtberger.utils.cliargsandopts;

import io.github.vaclavrechtberger.utils.cliargsandopts.exceptions.FailedToLoadOptions;
import io.github.vaclavrechtberger.utils.cliargsandopts.options.AbstractOptionsFactory;
import io.github.vaclavrechtberger.utils.cliargsandopts.options.Option;

import java.util.List;

public class Parser {
    /**
     * @throws io.github.vaclavrechtberger.utils.cliargsandopts.exceptions.MissingOption if mandatory option is missing
     * @throws io.github.vaclavrechtberger.utils.cliargsandopts.exceptions.DuplicateOption if one option is provided more than once
     * @throws io.github.vaclavrechtberger.utils.cliargsandopts.exceptions.UnknownOption if unknown option found
     * @throws io.github.vaclavrechtberger.utils.cliargsandopts.exceptions.InvalidOptionArgument if invalid argument is provided
     * @param args
     * @return List of program options
     */
    public List<Option> parse(String ... args) throws FailedToLoadOptions {
        // TODO support for more than one option
        return List.of(AbstractOptionsFactory.getInstance().parseOption(args));
    }
}
