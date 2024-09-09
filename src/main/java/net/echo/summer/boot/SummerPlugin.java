package net.echo.summer.boot;

import net.echo.summer.data.UserData;
import net.echo.summer.data.container.DataContainer;
import net.echo.summer.data.listeners.AccessListener;
import net.echo.summer.data.loader.DataLoader;
import org.bukkit.Bukkit;

import java.awt.*;

/**
 * The main plugin class for the SummerPlugin.
 * <p>
 * This class serves as the entry point for the plugin, providing methods for
 * enabling, disabling, and loading the plugin.
 *
 * @author echo
 * @since 1.0
 */
public abstract class SummerPlugin<D extends UserData> {

    private final SummerLoader<?> loader;
    private DataContainer<D> container;

    public SummerPlugin(SummerLoader<?> loader) {
        this.loader = loader;
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
     * Called when the plugin is loaded.
     * This method is typically used to perform any necessary setup or initialization. It's called before enable().
     * This is mostly used for Summer, if you want to override it, insert a super call.
     */
    public void load() {
        this.container = new DataContainer<>(getDataLoader());

        Bukkit.getPluginManager().registerEvents(new AccessListener(this), loader);
    }

    /**
     * Returns the loader associated with this plugin.
     */
    public SummerLoader<?> getLoader() {
        return loader;
    }

    /**
     * Returns an implementation of the {@link DataLoader} interface
     */
    public abstract DataLoader<D> getDataLoader();

    /**
     * Returns the {@link DataContainer} for the plugin
     */
    public DataContainer<D> getContainer() {
        return container;
    }
}
