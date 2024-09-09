package net.echo.spigotengine.commandsv2.processor;

import org.bukkit.command.CommandSender;

public interface Processor<T> {

    T process(CommandSender sender, String supplied);
}
