package net.echo.spigotengine.commandsv2.annotations;

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
