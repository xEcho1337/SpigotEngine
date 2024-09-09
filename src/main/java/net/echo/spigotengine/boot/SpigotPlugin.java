package net.echo.spigotengine.boot;

import net.echo.spigotengine.data.UserData;
import net.echo.spigotengine.data.container.DataContainer;
import net.echo.spigotengine.data.listeners.AccessListener;
import net.echo.spigotengine.data.loader.DataLoader;
import org.bukkit.Bukkit;

/**
 * The main plugin class.
 * <p>
 * This class serves as the entry point for the plugin, providing methods for
 * enabling, disabling, and loading the plugin.
 *
 * @author echo
 * @since 1.0
 */
public abstract class SpigotPlugin<D extends UserData> {

    private final PluginLoader<?> pluginLoader;
    private DataContainer<D> container;

    public SpigotPlugin(PluginLoader<?> pluginLoader) {
        this.pluginLoader = pluginLoader;
    }

    /**
     * Called when the plugin is enabled.
     * <p>
     * This method is typically used to initialize the plugin's functionality.
     */
    public void enable() {
    }

    /**
     * Called when the plugin is disabled.
     * <p>
     * This method is typically used to clean up or shutdown any resources used by the plugin.
     */
    public void disable() {
    }

    /**
     * Called once the plugin gets loaded.
     * <p>
     * This method is the first method called, even before startup()
     */
    public void load() {
    }

    /**
     * Called when the plugin gets enabled but before enable().
     * <p>
     * This method is used by SE to initialize, if you want to override it, insert a super call.
     */
    public void startup() {
        this.container = new DataContainer<>(getDataLoader());

        Bukkit.getPluginManager().registerEvents(new AccessListener(this), pluginLoader);

        loadListeners();
        loadCommands();
    }

    /**
     * Returns the loader associated with this plugin.
     */
    public PluginLoader<?> getLoader() {
        return pluginLoader;
    }

    /**
     * Returns an implementation of the {@link DataLoader} interface
     */
    public abstract DataLoader<D> getDataLoader();

    /**
     * Loads all the listeners of the plugin.
     */
    public abstract void loadListeners();

    /**
     * Loads all the commands of the plugin.
     */
    public abstract void loadCommands();

    /**
     * Returns the {@link DataContainer} for the plugin
     */
    public DataContainer<D> getContainer() {
        return container;
    }
}
