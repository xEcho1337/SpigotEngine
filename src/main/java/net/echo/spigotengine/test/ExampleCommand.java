package net.echo.spigotengine.test;

import net.echo.spigotengine.Example;
import net.echo.spigotengine.commandsv2.BaseCommand;
import net.echo.spigotengine.commandsv2.SenderFilter;
import net.echo.spigotengine.commandsv2.annotations.CommandData;
import net.echo.spigotengine.commandsv2.annotations.SubCommand;
import org.bukkit.entity.Player;

@CommandData(aliases = "example", permission = "example.permission", filter = SenderFilter.PLAYER_ONLY)
public class ExampleCommand extends BaseCommand<Example> {

    public ExampleCommand(Example plugin) {
        super(plugin);
    }

    @SubCommand(aliases = "hello", permission = "example.hello")
    public void onHello(Player sender) {
        sender.sendMessage("Hello, World!");
    }
}
