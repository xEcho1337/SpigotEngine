package net.echo.spigotengine.commands.processor.impl;

import net.echo.spigotengine.commands.processor.Processor;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;

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
