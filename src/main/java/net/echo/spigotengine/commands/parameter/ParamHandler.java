package net.echo.spigotengine.commands.parameter;

import net.echo.spigotengine.commands.processor.impl.*;
import net.echo.spigotengine.commands.processor.Processor;
import org.bukkit.command.CommandSender;

import java.util.HashMap;
import java.util.Map;

public class ParamHandler {

    private static final Map<Class<?>, Processor<?>> processors = new HashMap<>();

    static {
        registerDefaults();
    }

    public static void registerDefaults() {
        registerProcessor(new BooleanProcessor());
        registerProcessor(new DoubleProcessor());
        registerProcessor(new DurationProcessor());
        registerProcessor(new GamemodeProcessor());
        registerProcessor(new IntegerProcessor());
        registerProcessor(new LongProcessor());
        registerProcessor(new OfflinePlayerProcessor());
        registerProcessor(new PlayerProcessor());
    }

    public static void registerProcessor(Processor<?> processor) {
        processors.put(processor.getType(), processor);
    }

    @SuppressWarnings("unchecked")
    public static <T> T process(CommandSender sender, String input, Class<?> type) {
        Processor<?> processor = processors.get(type);

        if (processor == null) return null;

        return (T) processor.process(sender, input);
    }
}
