package net.echo.spigotengine.commandsv2;

import java.util.ArrayList;
import java.util.List;

public class CommandHandler {

    private static final List<BaseCommand<?>> commands = new ArrayList<>();

    public static void register(BaseCommand<?> command) {
        commands.add(command);
    }

    public static List<BaseCommand<?>> getCommands() {
        return commands;
    }
}
