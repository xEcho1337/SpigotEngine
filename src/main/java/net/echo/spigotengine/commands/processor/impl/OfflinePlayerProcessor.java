package net.echo.spigotengine.commands.processor.impl;

import net.echo.spigotengine.commands.processor.Processor;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;

public class OfflinePlayerProcessor extends Processor<OfflinePlayer> {

    @Override
    public OfflinePlayer process(CommandSender sender, String supplied) {
        return Bukkit.getOfflinePlayer(supplied);
    }
}
