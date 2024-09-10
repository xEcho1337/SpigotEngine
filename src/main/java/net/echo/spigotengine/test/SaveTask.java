package net.echo.spigotengine.test;

import net.echo.spigotengine.tasks.Task;

@Task(async = true, repeating = true, period = 20 * 20)
public class SaveTask implements Runnable {

    @Override
    public void run() {
        // Saving here
    }
}
