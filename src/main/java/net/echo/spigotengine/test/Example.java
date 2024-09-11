package net.echo.spigotengine.test;

import net.echo.spigotengine.boot.PluginLoader;
import net.echo.spigotengine.boot.SpigotPlugin;
import net.echo.spigotengine.data.UserData;
import net.echo.spigotengine.data.loader.DataLoader;

public final class Example extends SpigotPlugin<UserData> {

    private final PlayerDataLoader dataLoader = new PlayerDataLoader();

    public Example(PluginLoader<?> pluginLoader) {
        super(pluginLoader);
    }

    @Override
    public void enable() {
        super.enable();
    }

    @Override
    public void disable() {
        super.disable();
    }

    @Override
    public DataLoader<UserData> getDataLoader() {
        return dataLoader;
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
        taskHandler.registerAll("net.echo.spigot.tasks");
    }
}
