package net.echo.spigotengine.commands.processor.impl;

import net.echo.spigotengine.commands.processor.Processor;
import org.bukkit.command.CommandSender;

public class IntegerProcessor extends Processor<Integer> {

    @Override
    public Integer process(CommandSender sender, String supplied) {
        return Integer.parseInt(supplied);
    }
}
