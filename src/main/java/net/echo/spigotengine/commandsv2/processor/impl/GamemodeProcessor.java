package net.echo.spigotengine.commandsv2.processor.impl;

import net.echo.spigotengine.commandsv2.processor.Processor;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GamemodeProcessor extends Processor<GameMode> {

    public GameMode process(CommandSender sender, String supplied) {
        if (supplied.equalsIgnoreCase("survival") || supplied.equalsIgnoreCase("s") || supplied.equals("0")) {
            return GameMode.SURVIVAL;
        }

        if (supplied.equalsIgnoreCase("creative") || supplied.equalsIgnoreCase("c") || supplied.equals("1")) {
            return GameMode.CREATIVE;
        }

        if (supplied.equalsIgnoreCase("adventure") || supplied.equalsIgnoreCase("a") || supplied.equals("2")) {
            return GameMode.ADVENTURE;
        }

        if (supplied.equalsIgnoreCase("spectator") || supplied.equalsIgnoreCase("sp") || supplied.equals("3")) {
            return GameMode.SPECTATOR;
        }

        return null;
    }
}
