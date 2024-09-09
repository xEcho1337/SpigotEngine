package net.echo.summer;

import net.echo.summer.boot.SummerLoader;

public class Loader extends SummerLoader<Summer> {

    @Override
    public Summer getPlugin() {
        return new Summer(this);
    }
}
