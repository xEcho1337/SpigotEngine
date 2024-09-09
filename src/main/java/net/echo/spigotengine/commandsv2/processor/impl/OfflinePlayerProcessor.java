package net.echo.spigotengine.commandsv2.processor.impl;

import net.echo.spigotengine.commandsv2.processor.Processor;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;

public class OfflinePlayerProcessor extends Processor<OfflinePlayer> {

    @Override
    public OfflinePlayer process(CommandSender sender, String supplied) {
        return Bukkit.getOfflinePlayer(supplied);
    }
}
