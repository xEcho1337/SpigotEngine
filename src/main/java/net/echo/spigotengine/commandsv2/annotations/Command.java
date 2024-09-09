package net.echo.spigotengine.commandsv2.annotations;

import net.echo.spigotengine.commandsv2.SenderFilter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Command {

    /**
     * A list of aliases that the command can be called with
     */
    String[] aliases();

    /**
     * The permission required to run the command
     */
    String permission();

    /**
     * The filter of the sender, see {@link SenderFilter}
     */
    SenderFilter filter() default SenderFilter.EVERYONE;
}
