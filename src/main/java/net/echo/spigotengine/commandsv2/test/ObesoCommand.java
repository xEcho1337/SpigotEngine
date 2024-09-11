package net.echo.spigotengine.commandsv2.test;

import net.echo.spigotengine.commandsv2.BaseCommand;
import net.echo.spigotengine.commandsv2.annotations.CommandData;
import net.echo.spigotengine.commandsv2.annotations.Default;
import net.echo.spigotengine.commandsv2.SenderFilter;
import net.echo.spigotengine.commandsv2.annotations.SubCommand;
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
