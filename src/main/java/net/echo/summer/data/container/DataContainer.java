package net.echo.summer.data.container;

import net.echo.summer.data.LoadResult;
import net.echo.summer.data.UserData;
import net.echo.summer.data.loader.DataLoader;
import org.bukkit.entity.Player;

import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Consumer;

/**
 * A thread-safe container for player data.
 *
 * @author echo
 * @since 1.0
 */
public class DataContainer<D extends UserData> {

    private final ConcurrentMap<UUID, D> data = new ConcurrentHashMap<>();
    private final DataLoader<D> dataLoader;

    public DataContainer(DataLoader<D> dataLoader) {
        this.dataLoader = dataLoader;
    }

    /**
     * Returns the data for a player given the uuid
     */
    public D get(UUID uuid) {
        D cached = data.get(uuid);

        if (cached == null) {
            throw new NullPointerException("No data stored for " + uuid);
        }

        return cached;
    }

    /**
     * Returns the data for a player given the player instance
     */
    public D get(Player player) {
        return get(player.getUniqueId());
    }

    /**
     * Puts a data object into the container
     */
    public void put(D data) {
        this.data.put(data.getUuid(), data);
    }

    /**
     * Gets all the data in the container
     */
    public Iterator<D> getAll() {
        return data.values().iterator();
    }

    /**
     * Executes a consumer on all the data in the container
     */
    public void forEach(Consumer<D> consumer) {
        data.values().forEach(consumer);
    }

    public void unload(Player player) {
        this.data.remove(player.getUniqueId());
    }

    public LoadResult load(UUID uuid) {
        D data = dataLoader.load(uuid).orElse(null);

        if (data == null) {
            return LoadResult.FAIL;
        }

        put(data);
        return LoadResult.SUCCESS;
    }
}
