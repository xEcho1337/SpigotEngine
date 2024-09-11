package net.echo.spigotengine.commands.processor.impl;

import net.echo.spigotengine.commands.duration.Duration;
import net.echo.spigotengine.commands.processor.Processor;
import org.bukkit.command.CommandSender;

public class DurationProcessor extends Processor<Duration> {

    @Override
    public Duration process(CommandSender sender, String supplied) {
        String upperCase = supplied.toLowerCase();
        long value = Long.parseLong(supplied.substring(0, supplied.length() - 1));

        if (upperCase.endsWith("s")) value *= 1000;
        else if (upperCase.endsWith("m")) value *= 1000 * 60;
        else if (upperCase.endsWith("h")) value *= 1000 * 60 * 60;
        else if (upperCase.endsWith("d")) value *= 1000 * 60 * 60 * 24;
        else if (upperCase.endsWith("w")) value *= 1000 * 60 * 60 * 24 * 7;
        else if (upperCase.endsWith("y")) value *= 1000L * 60 * 60 * 24 * 365;

        return new Duration(value);
    }
}
