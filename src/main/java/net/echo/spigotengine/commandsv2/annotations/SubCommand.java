package net.echo.spigotengine.commandsv2.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface SubCommand {

    /**
     * The aliases of the subcommand
     */
    String[] aliases();

    /**
     * The permission required to use the subcommand
     */
    String permission() default "";
}
