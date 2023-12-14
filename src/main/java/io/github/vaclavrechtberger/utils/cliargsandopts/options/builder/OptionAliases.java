package io.github.vaclavrechtberger.utils.cliargsandopts.options.builder;

import java.util.Set;

public interface OptionAliases {
    OptionDescription withAliases(Set<String> aliases);
}
