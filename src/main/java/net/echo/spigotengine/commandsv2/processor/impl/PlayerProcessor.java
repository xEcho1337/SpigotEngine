package net.echo.spigotengine.commandsv2.processor.impl;

import net.echo.spigotengine.commandsv2.processor.Processor;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerProcessor implements Processor<Player> {

    @Override
    public Player process(CommandSender sender, String supplied) {
        return Bukkit.getPlayer(supplied);
    }
}
