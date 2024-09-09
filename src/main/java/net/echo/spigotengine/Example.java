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
    public void loadListeners() {

    }

    @Override
    public void loadCommands() {

    }
}
