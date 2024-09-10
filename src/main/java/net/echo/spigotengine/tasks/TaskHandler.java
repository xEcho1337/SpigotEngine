package net.echo.spigotengine.tasks;

import com.google.common.base.Preconditions;
import net.echo.spigotengine.boot.SpigotPlugin;
import net.echo.spigotengine.utils.Initializer;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitScheduler;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class TaskHandler<P extends SpigotPlugin<?>> {

    private static final BukkitScheduler executor = Bukkit.getScheduler();
    private final P plugin;

    protected TaskHandler(P plugin) {
        this.plugin = plugin;
    }

    public static <T extends SpigotPlugin<?>> TaskHandler<T> create(T plugin) {
        return new TaskHandler<>(plugin);
    }

    public void registerAll(String path) {
        Initializer.create(Runnable.class).consumeAll(plugin, path, this::register);
    }

    public <T extends Runnable> void submit(@NotNull T task, long delay) {
        Preconditions.checkNotNull(task);
        executor.runTaskLater(plugin.getLoader(), task, delay);
    }

    public <T extends Runnable> void submitAsync(@NotNull T task, long delay) {
        Preconditions.checkNotNull(task);
        executor.runTaskLaterAsynchronously(plugin.getLoader(), task, delay);
    }

    public <T extends Runnable> void register(@NotNull T task) {
        Preconditions.checkNotNull(task);

        if (!task.getClass().isAnnotationPresent(Task.class)) {
            throw new IllegalStateException(task.getClass().getSimpleName() + " does not have the @Task annotation");
        }

        Task data = task.getClass().getAnnotation(Task.class);

        if (data.async()) {
            if (data.repeating()) {
                executor.runTaskTimerAsynchronously(plugin.getLoader(), task, data.delay(), data.period());
            } else {
                executor.runTaskAsynchronously(plugin.getLoader(), task);
            }
        } else {
            if (data.repeating()) {
                executor.runTaskTimer(plugin.getLoader(), task, data.delay(), data.period());
            } else {
                executor.runTask(plugin.getLoader(), task);
            }
        }
    }
}
