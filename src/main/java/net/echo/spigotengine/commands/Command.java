package net.echo.spigotengine.commands;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Command {
    /**
     * Root command names
     */
    String[] names();

    /**
     * Command's permission
     */
    String permission() default "";

    /**
     * Whether the command is run asynchronously
     */
    boolean async() default false;

    /**
     * Gets the description of the command
     */
    String description() default "This command doesn't have a description.";

    /**
     * Checks if command is console only
     */
    boolean consoleOnly() default false;

    /**
     * Checks if command is player only
     */
    boolean playerOnly() default false;
}