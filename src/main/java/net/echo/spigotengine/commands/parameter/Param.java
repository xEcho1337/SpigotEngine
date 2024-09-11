package net.echo.spigotengine.commands.parameter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface Param {

    /**
     * The name of the parameter.
     */
    String name();

    /**
     * If true, the rest of the arguments get concatenated together.
     */
    boolean concated() default false;

    /**
     * Checks to see if a parameter is required.
     */
    boolean required() default true;

    /**
     * The default value if required is false and the value is null.
     */
    String defaultValue() default "";
}
