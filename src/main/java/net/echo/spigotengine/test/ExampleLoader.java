package net.echo.spigotengine.test;

import net.echo.spigotengine.boot.PluginLoader;

public class ExampleLoader extends PluginLoader<Example> {

    @Override
    public Example getPlugin() {
        return new Example(this);
    }
}
