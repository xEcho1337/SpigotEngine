package net.echo.spigotengine.commandsv2.processor.impl;

import net.echo.spigotengine.commandsv2.processor.Processor;
import org.bukkit.command.CommandSender;

import java.util.HashMap;
import java.util.Map;

public class BooleanProcessor extends Processor<Boolean> {

    private final Map<String, Boolean> values = new HashMap<>();

    public BooleanProcessor() {
        values.put("true", true);
        values.put("on", true);
        values.put("yes", true);
        values.put("enable", true);
        values.put("false", false);
        values.put("off", false);
        values.put("no", false);
        values.put("disable", false);
    }

    @Override
    public Boolean process(CommandSender sender, String supplied) {
        return values.get(supplied.toLowerCase());
    }
}
