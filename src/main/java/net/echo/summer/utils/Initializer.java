package net.echo.summer.utils;

import com.google.common.reflect.ClassPath;
import net.echo.summer.boot.SummerPlugin;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.function.Consumer;

/**
 * Simple class to consume all the classes in a package.
 * Useful to register all commands or all listeners all at once.
 *
 * @author echo
 * @since 1.0
 */
public class Initializer<T> {

    public static <T> Initializer<T> create(Class<T> type) {
        return new Initializer<>();
    }

    public <P extends SummerPlugin<?>> void registerAll(P plugin, String path, Consumer<T> consumer) {
        try {
            ClassPath.from(plugin.getClass().getClassLoader())
                    .getAllClasses()
                    .stream()
                    .filter(info -> info.getPackageName().startsWith(path))
                    .forEach(info -> consumeClassInfo(plugin, info, consumer));
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }

    @SuppressWarnings("all")
    private <P extends SummerPlugin<?>> void consumeClassInfo(P plugin, ClassPath.ClassInfo info, Consumer<T> consumer) {
        try {
            Class<?> clazz = info.load();

            try {
                // Try to find the no-arg constructor
                Constructor<?> noArgConstructor = clazz.getDeclaredConstructor();
                noArgConstructor.setAccessible(true);

                T instance = (T) noArgConstructor.newInstance();
                consumer.accept(instance);
            } catch (NoSuchMethodException e) {
                // OK, this class has a constructor, it's surely an instance
                try {
                    Constructor<?> kitPvPConstructor = clazz.getDeclaredConstructor(plugin.getClass());
                    kitPvPConstructor.setAccessible(true);

                    T instance = (T) kitPvPConstructor.newInstance(plugin);
                    consumer.accept(instance);
                } catch (NoSuchMethodException | IllegalAccessException | InstantiationException |
                         InvocationTargetException ex) {
                    ex.printStackTrace(System.err);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}
