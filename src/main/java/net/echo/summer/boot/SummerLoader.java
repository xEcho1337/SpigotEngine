package net.echo.summer.boot;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Entry point for Bukkit plugins. Should not be confused with {@link SummerPlugin}.
 * This class extends {@link JavaPlugin} and builds a bridge between the Bukkit API and Summer plugins.
 *
 * @author echo
 * @since 1.0
 */
public abstract class SummerLoader<P extends SummerPlugin<?>> extends JavaPlugin {

    /**
     * Returns the plugin instance associated with this loader.
     *
     * @return the plugin instance
     */
    public abstract P getPlugin();

    @Override
    public void onEnable() {
        getPlugin().enable();
    }
    
    @Override
    public void onDisable() {
        getPlugin().disable();
    }

    @Override
    public void onLoad() {
        getPlugin().load();
    }
}
