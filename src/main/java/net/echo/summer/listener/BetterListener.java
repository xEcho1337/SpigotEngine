package net.echo.summer.listener;

import net.echo.summer.boot.SummerPlugin;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

/**
 * A shortcut to easily implements listeners.
 *
 * @author echo
 * @since 1.0
 */
public class BetterListener<I extends SummerPlugin<?>> implements Listener {

    protected I plugin;

    public BetterListener(I plugin) {
        this.plugin = plugin;
    }

    /**
     * This method is not called by Summer, should instead be used to notify the listener about config or other changes.
     */
    public void reload() {
    }

    /**
     * Called once when the listener gets registered, with the pure intention to register all the events in the class.
     */
    public void load() {
        Bukkit.getPluginManager().registerEvents(this, plugin.getLoader());
    }
}

