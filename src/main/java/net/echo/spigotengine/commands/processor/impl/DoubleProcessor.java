package net.echo.spigotengine.commands.processor.impl;

import net.echo.spigotengine.commands.processor.Processor;
import org.bukkit.command.CommandSender;

public class DoubleProcessor extends Processor<Double> {

    @Override
    public Double process(CommandSender sender, String supplied) {
        return Double.parseDouble(supplied);
    }
}
