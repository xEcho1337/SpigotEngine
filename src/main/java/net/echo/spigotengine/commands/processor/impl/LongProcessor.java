package net.echo.spigotengine.commands.processor.impl;

import net.echo.spigotengine.commands.processor.Processor;
import org.bukkit.command.CommandSender;

public class LongProcessor extends Processor<Long> {

    @Override
    public Long process(CommandSender sender, String supplied) {
        return Long.parseLong(supplied);
    }
}
