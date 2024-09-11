package net.echo.spigotengine.commands.annotations;

import net.echo.spigotengine.commands.SenderFilter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface CommandData {

    /**
     * A list of aliases that the command can be called with
     */
    String[] aliases();

    /**
     * The permission required to run the command
     */
    String permission() default "";

    /**
     * The filter of the sender, see {@link SenderFilter}
     */
    SenderFilter filter() default SenderFilter.EVERYONE;
}
