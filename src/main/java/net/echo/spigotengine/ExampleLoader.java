package net.echo.spigotengine;

public class ExampleLoader extends net.echo.spigotengine.boot.PluginLoader<Example> {

    @Override
    public Example getPlugin() {
        return new Example(this);
    }
}
