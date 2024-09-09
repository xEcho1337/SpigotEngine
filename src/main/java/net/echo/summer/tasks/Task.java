package net.echo.summer.tasks;

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
