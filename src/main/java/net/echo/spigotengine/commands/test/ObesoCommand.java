package net.echo.spigotengine.commands.test;

import net.echo.spigotengine.commands.BaseCommand;
import net.echo.spigotengine.commands.annotations.CommandData;
import net.echo.spigotengine.commands.annotations.Default;
import net.echo.spigotengine.commands.SenderFilter;
import net.echo.spigotengine.commands.annotations.SubCommand;
import net.echo.spigotengine.test.Example;
import org.bukkit.entity.Player;

@CommandData(aliases = "obeso", permission = "boobsmc.obeso", filter = SenderFilter.PLAYER_ONLY)
public class ObesoCommand extends BaseCommand<Example> {

    public ObesoCommand(Example plugin) {
        super(plugin);
    }

    @Default
    public void onHelp(Player player) {

    }

    @SubCommand(aliases = "poop", permission = "boobsmc.obeso")
    public void onPoop(Player player, Statistic statistic) {
    }

    public enum Statistic {

        KILLS,
        DEATHS,
        STREAK
    }
}
