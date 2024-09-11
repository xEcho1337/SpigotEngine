package net.echo.spigotengine.commands.processor.impl;

import net.echo.spigotengine.commands.processor.Processor;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerProcessor extends Processor<Player> {

    @Override
    public Player process(CommandSender sender, String supplied) {
        return Bukkit.getPlayer(supplied);
    }
}
