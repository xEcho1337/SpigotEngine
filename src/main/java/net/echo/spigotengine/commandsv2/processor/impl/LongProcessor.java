package net.echo.spigotengine.commandsv2.processor.impl;

import net.echo.spigotengine.commandsv2.processor.Processor;
import org.bukkit.command.CommandSender;

public class LongProcessor implements Processor<Long> {

    @Override
    public Long process(CommandSender sender, String supplied) {
        return Long.parseLong(supplied);
    }
}
