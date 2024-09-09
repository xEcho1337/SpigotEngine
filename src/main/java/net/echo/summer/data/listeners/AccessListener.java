package net.echo.summer.data.listeners;

import net.echo.summer.boot.SummerPlugin;
import net.echo.summer.data.LoadResult;
import net.echo.summer.data.UserData;
import net.echo.summer.listener.BetterListener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class AccessListener extends BetterListener<SummerPlugin<?>> {

    public AccessListener(SummerPlugin<?> plugin) {
        super(plugin);
    }

    @EventHandler (priority = EventPriority.HIGHEST)
    public void onAsyncPreLogin(AsyncPlayerPreLoginEvent event) {
        if (event.getLoginResult() != AsyncPlayerPreLoginEvent.Result.ALLOWED) return;

        LoadResult result = plugin.getContainer().load(event.getUniqueId());

        if (result == LoadResult.FAIL) {
            event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, "Failed to load data");
        }
    }

    @EventHandler (priority = EventPriority.HIGHEST)
    public void onPreLogin(PlayerLoginEvent event) {
        UserData data = plugin.getContainer().get(event.getPlayer());

        if (data == null) {
            event.disallow(PlayerLoginEvent.Result.KICK_OTHER, "Data not found during login event.");
        } else if (event.getResult() != PlayerLoginEvent.Result.ALLOWED) {
            plugin.getContainer().unload(event.getPlayer());
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        plugin.getContainer().unload(event.getPlayer());
    }
}
