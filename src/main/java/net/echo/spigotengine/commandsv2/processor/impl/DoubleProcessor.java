package net.echo.spigotengine.commandsv2.processor.impl;

import net.echo.spigotengine.commandsv2.processor.Processor;
import org.bukkit.command.CommandSender;

public class DoubleProcessor extends Processor<Double> {

    @Override
    public Double process(CommandSender sender, String supplied) {
        return Double.parseDouble(supplied);
    }
}
