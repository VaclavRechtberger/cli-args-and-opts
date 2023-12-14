package io.github.vaclavrechtberger.utils.cliargsandopts;

import io.github.vaclavrechtberger.utils.cliargsandopts.exceptions.FailedToLoadOptions;
import io.github.vaclavrechtberger.utils.cliargsandopts.options.Option;

import java.util.List;

public class Main {
    public static void main(String ... args) {
        try {
            List<Option> options = new Parser().parse("-v", "1");
            Option option = options.get(0);
            System.out.println(option.getDescription() + " ... " + option.getValue());;
        } catch (FailedToLoadOptions e) {
            e.printStackTrace();
            // log it etc...
        }
    }
}
