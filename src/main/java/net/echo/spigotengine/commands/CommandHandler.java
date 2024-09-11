package net.echo.spigotengine.commands;

import net.echo.spigotengine.boot.SpigotPlugin;
import net.echo.spigotengine.utils.Initializer;

import java.util.ArrayList;
import java.util.List;

/**
 * Class used for handling commands.
 * 
 * @author echo
 * @since 1.0.0
 */
public class CommandHandler<P extends SpigotPlugin<?>> {

    private static final List<BaseCommand<?>> commands = new ArrayList<>();
    private final P plugin;

    protected CommandHandler(P plugin) {
        this.plugin = plugin;
    }

    /**
     * Creates an instance of the command handler.
     *
     * @param plugin the parent plugin
     */
    public static <T extends SpigotPlugin<?>> CommandHandler<T> create(T plugin) {
        return new CommandHandler<>(plugin);
    }

    /**
     * Registers all the commands in the specified path.
     */
    public void registerAll(String path) {
        Initializer.consumeAll(BaseCommand.class, plugin, path, this::register);
    }

    /**
     * Registers a single command.
     *
     * @param command the command
     */
    public CommandHandler<P> register(BaseCommand<?> command) {
        commands.add(command);
        return this;
    }

    /**
     * Returns the list of all commands.
     */
    public static List<BaseCommand<?>> getCommands() {
        return commands;
    }
}
