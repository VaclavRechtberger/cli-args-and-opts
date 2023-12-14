package io.github.vaclavrechtberger.utils.cliargsandopts.options.types;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Each ({@link TypeFactory} annotated with this annotation will by automatically registered in {@link io.github.vaclavrechtberger.utils.cliargsandopts.options.AbstractOptionsFactory}
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface RegisterTypeFactory{
}
