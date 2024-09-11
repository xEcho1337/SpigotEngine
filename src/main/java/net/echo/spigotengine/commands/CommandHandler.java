package net.echo.spigotengine.commands;

import net.echo.spigotengine.boot.SpigotPlugin;
import net.echo.spigotengine.utils.Initializer;

import java.util.ArrayList;
import java.util.List;

public class CommandHandler<P extends SpigotPlugin<?>> {

    private static final List<BaseCommand<?>> commands = new ArrayList<>();
    private final P plugin;

    protected CommandHandler(P plugin) {
        this.plugin = plugin;
    }

    public static <T extends SpigotPlugin<?>> CommandHandler<T> create(T plugin) {
        return new CommandHandler<>(plugin);
    }

    public void registerAll(String path) {
        Initializer.create(BaseCommand.class).consumeAll(plugin, path, this::register);
    }

    public CommandHandler<P> register(BaseCommand<?> command) {
        commands.add(command);
        return this;
    }

    public static List<BaseCommand<?>> getCommands() {
        return commands;
    }
}
