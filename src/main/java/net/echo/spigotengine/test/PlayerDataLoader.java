package net.echo.spigotengine.test;

import net.echo.spigotengine.data.UserData;
import net.echo.spigotengine.data.loader.DataLoader;

import java.util.Optional;
import java.util.UUID;

public class PlayerDataLoader implements DataLoader<UserData> {

    @Override
    public Optional<UserData> load(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public Optional<UserData> load(String name) {
        return Optional.empty();
    }
}
