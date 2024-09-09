package net.echo.spigotengine.commandsv2.test;

import net.echo.spigotengine.commandsv2.annotations.Command;
import net.echo.spigotengine.commandsv2.annotations.Default;
import net.echo.spigotengine.commandsv2.SenderFilter;
import net.echo.spigotengine.commandsv2.annotations.SubCommand;
import org.bukkit.entity.Player;

@Command(aliases = "obeso", permission = "boobsmc.obeso", filter = SenderFilter.PLAYER_ONLY)
public class ObesoCommand {

    @Default
    public void onHelp(Player player) {

    }

    @SubCommand(aliases = "obeso", permission = "boobsmc.obeso")
    public void onObeso(Player player) {

    }
}
