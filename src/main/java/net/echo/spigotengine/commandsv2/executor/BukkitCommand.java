package net.echo.spigotengine.commandsv2.executor;

import net.echo.spigotengine.ExampleLoader;
import net.echo.spigotengine.commandsv2.BaseCommand;
import net.echo.spigotengine.commandsv2.CommandHandler;
import net.echo.spigotengine.commandsv2.annotations.CommandData;
import net.echo.spigotengine.commandsv2.parameter.ParamHandler;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BukkitCommand extends Command {

    public BukkitCommand(CommandData data) {
        super(data.aliases()[0]);

        try {
            Class<?> serverClass = Bukkit.getServer().getClass();
            Field commandMap = serverClass.getDeclaredField("commandMap");

            commandMap.setAccessible(true);

            CommandMap wrapped = (CommandMap) commandMap.get(Bukkit.getServer());
            wrapped.register(ExampleLoader.getPlugin(ExampleLoader.class).getName(), this);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        List<BaseCommand<?>> commands = CommandHandler.getCommands();

        for (BaseCommand<?> command : commands) {
            for (String alias : command.getCommandData().aliases()) {
                if (!alias.equalsIgnoreCase(commandLabel)) continue;

                processAlias(sender, command, args);
            }
        }

        return false;
    }

    private void processAlias(CommandSender sender, BaseCommand<?> command, String[] args) {
        try {
            if (args.length == 0) {
                Method defaultMethod = command.getDefaultMethod();
                Parameter[] params = defaultMethod.getParameters();

                if (params.length == 1) {
                    defaultMethod.invoke(command, sender);
                } else {
                    // TODO: Usage message and error handling
                }

                return;
            }

            String sub = args[0];
            Method method = command.getSubCommand(sub);

            if (method == null) return; // TODO: Usage message and error handling

            Parameter[] params = method.getParameters();

            // We subtract one because of the sub command, and another one because of the sender
            if (params.length - 2 != args.length) return; // TODO: Usage message and error handling

            String[] copyArgs = new String[args.length - 1];
            System.arraycopy(args, 1, copyArgs, 0, args.length - 1);

            List<Object> objects = new ArrayList<>(Collections.singletonList(sender));

            for (int i = 1; i < copyArgs.length; i++) {
                Parameter parameter = params[i];

                // TODO: CHeck for annotation

                Object output = ParamHandler.process(sender, copyArgs[i]);

                if (output == null || parameter.getType().isAssignableFrom(output.getClass())) continue; // TODO: Usage message and error handling

                objects.add(output);
            }

            // 200 iq reflection type of shit
            method.invoke(command, objects.toArray());
        } catch (Exception e) {
            // Ignore
        }
    }
}
