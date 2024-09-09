package net.echo.spigotengine.commands.parameter;

import net.echo.spigotengine.commands.duration.Duration;
import net.echo.spigotengine.commands.node.ArgumentNode;
import net.echo.spigotengine.commands.parameter.impl.*;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParamProcessor {
    private static final HashMap<Class<?>, Processor<?>> processors = new HashMap<>();
    private static boolean loaded = false;

    private final ArgumentNode node;
    private final String supplied;
    private final CommandSender sender;

    public ParamProcessor(ArgumentNode node, String supplied, CommandSender sender) {
        this.node = node;
        this.supplied = supplied;
        this.sender = sender;
    }

    public static HashMap<Class<?>, Processor<?>> getProcessors() {
        return ParamProcessor.processors;
    }

    /**
     * Processes the param into an object
     *
     * @return Processed Object
     */
    public Object get() {
        if (!loaded) loadProcessors();

        Processor<?> processor = processors.get(node.getParameter().getType());
        if (processor == null) return supplied;

        return processor.process(sender, supplied);
    }

    /**
     * Gets the tab completions for the param processor
     *
     * @return Tab Completions
     */
    public List<String> getTabComplete() {
        if (!loaded) loadProcessors();

        Processor<?> processor = processors.get(node.getParameter().getType());
        if (processor == null) return new ArrayList<>();

        return processor.tabComplete(sender, supplied);
    }

    /**
     * Creates a new processor
     *
     * @param processor Processor
     */
    public static void createProcessor(Processor<?> processor) {
        processors.put(processor.getType(), processor);
    }

    /**
     * Loads the processors
     */
    public static void loadProcessors() {
        loaded = true;

        processors.put(int.class, new IntegerProcessor());
        processors.put(long.class, new LongProcessor());
        processors.put(double.class, new DoubleProcessor());
        processors.put(boolean.class, new BooleanProcessor());

        processors.put(ChatColor.class, new ChatColorProcessor());
        processors.put(Player.class, new PlayerProcessor());
        processors.put(OfflinePlayer.class, new OfflinePlayerProcessor());
        processors.put(World.class, new WorldProcessor());
        processors.put(Duration.class, new DurationProcessor());
        processors.put(GameMode.class, new GamemodeProcessor());
    }

    public ArgumentNode getNode() {
        return this.node;
    }

    public String getSupplied() {
        return this.supplied;
    }

    public CommandSender getSender() {
        return this.sender;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ParamProcessor)) return false;
        final ParamProcessor other = (ParamProcessor) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$node = this.getNode();
        final Object other$node = other.getNode();
        if (this$node == null ? other$node != null : !this$node.equals(other$node)) return false;
        final Object this$supplied = this.getSupplied();
        final Object other$supplied = other.getSupplied();
        if (this$supplied == null ? other$supplied != null : !this$supplied.equals(other$supplied)) return false;
        final Object this$sender = this.getSender();
        final Object other$sender = other.getSender();
        if (this$sender == null ? other$sender != null : !this$sender.equals(other$sender)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ParamProcessor;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $node = this.getNode();
        result = result * PRIME + ($node == null ? 43 : $node.hashCode());
        final Object $supplied = this.getSupplied();
        result = result * PRIME + ($supplied == null ? 43 : $supplied.hashCode());
        final Object $sender = this.getSender();
        result = result * PRIME + ($sender == null ? 43 : $sender.hashCode());
        return result;
    }

    public String toString() {
        return "ParamProcessor(node=" + this.getNode() + ", supplied=" + this.getSupplied() + ", sender=" + this.getSender() + ")";
    }
}
