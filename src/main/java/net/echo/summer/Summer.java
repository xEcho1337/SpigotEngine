package net.echo.summer;

import net.echo.summer.boot.SummerLoader;
import net.echo.summer.boot.SummerPlugin;
import net.echo.summer.data.UserData;
import net.echo.summer.data.loader.DataLoader;

public final class Summer extends SummerPlugin<UserData> {

    public Summer(SummerLoader<?> loader) {
        super(loader);
    }

    @Override
    public void enable() {
        super.enable();
    }

    @Override
    public void disable() {
        super.disable();
    }

    @Override
    public void load() {
        super.load();
    }

    @Override
    public DataLoader<UserData> getDataLoader() {
        return null;
    }
}
