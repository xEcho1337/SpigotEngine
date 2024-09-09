package net.echo.spigotengine.tasks;

/**
 * An annotation containing various information about a task.
 *
 * @author echo
 * @since 1.0
 */
public @interface Task {

    /**
     * Determines whether the task should be run asynchronously
     */
    boolean async() default false;

    /**
     * Determines whether the task should repeat
     */
    boolean repeating() default false;

    /**
     * Determines the delay in ticks
     */
    int delay() default 0;
}
