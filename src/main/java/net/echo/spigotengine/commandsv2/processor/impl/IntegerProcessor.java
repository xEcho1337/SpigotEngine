package net.echo.spigotengine.commandsv2.processor.impl;

import net.echo.spigotengine.commandsv2.processor.Processor;
import org.bukkit.command.CommandSender;

public class IntegerProcessor extends Processor<Integer> {

    @Override
    public Integer process(CommandSender sender, String supplied) {
        return Integer.parseInt(supplied);
    }
}
