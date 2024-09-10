package net.echo.spigotengine;

import net.echo.spigotengine.boot.PluginLoader;
import net.echo.spigotengine.boot.SpigotPlugin;
import net.echo.spigotengine.data.UserData;
import net.echo.spigotengine.data.loader.DataLoader;

public final class Example extends SpigotPlugin<UserData> {

    public Example(PluginLoader<?> pluginLoader) {
        super(pluginLoader);
    }

    @Override
    public DataLoader<UserData> getDataLoader() {
        return null;
    }

    @Override
    public void enable() {

    }

    @Override
    public void registerListeners() {
        listenerHandler.registerAll("net.echo.listeners");
    }

    @Override
    public void registerCommands() {
        commandHandler.registerAll("net.echo.commands");
    }

    @Override
    public void registerTasks() {
        taskHandler.registerAll("net.echo.tasks");
    }
}
