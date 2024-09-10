package net.echo.spigotengine.listener;

import net.echo.spigotengine.boot.SpigotPlugin;
import net.echo.spigotengine.utils.Initializer;

public class ListenerHandler<P extends SpigotPlugin<?>> {

    private final P plugin;

    protected ListenerHandler(P plugin) {
        this.plugin = plugin;
    }

    public static <T extends SpigotPlugin<?>> ListenerHandler<T> create(T plugin) {
        return new ListenerHandler<>(plugin);
    }

    public void registerAll(String path) {
        Initializer.create(BetterListener.class).consumeAll(plugin, path, BetterListener::load);
    }
}
