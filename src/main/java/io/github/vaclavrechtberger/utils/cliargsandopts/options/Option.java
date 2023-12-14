package io.github.vaclavrechtberger.utils.cliargsandopts.options;

import io.github.vaclavrechtberger.utils.cliargsandopts.options.types.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
public class Option {
    @Getter
    private Set<String> aliases;
    @Getter
    private boolean mandatory;
    private String description;
    @Getter
    private boolean withParameter;
    @Getter
    private Type type;
    private Object value;
    @Getter
    private boolean withDefaultValue;
    @Getter
    private Object defaultValue;
    /**
     * True if value is present
     */
    @Getter
    @Setter
    private boolean present;

    public String getDescription() {
        // TODO concatenate with type description and default values...
        return description;
    }

    public void setValue(String ... args) {
        value = type.parseValue(args);
    }

    public Object getValue() {
        if (!isPresent()) {
            return defaultValue;
        } else {
            return value;
        }
    }
}
