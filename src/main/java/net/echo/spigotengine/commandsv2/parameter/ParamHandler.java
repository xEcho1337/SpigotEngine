package net.echo.spigotengine.commandsv2.parameter;

import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MutableClassToInstanceMap;
import net.echo.spigotengine.commandsv2.processor.impl.*;
import net.echo.spigotengine.commandsv2.processor.Processor;
import org.bukkit.command.CommandSender;

import java.util.HashMap;
import java.util.Map;

public class ParamHandler {

    // TODO: Fix generics
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

    public static <T> T process(CommandSender sender, String input, Class<?> type) {
        Processor<?> processor = processors.get(type);

        if (processor == null) return null;

        return (T) processor.process(sender, input);
    }
}
