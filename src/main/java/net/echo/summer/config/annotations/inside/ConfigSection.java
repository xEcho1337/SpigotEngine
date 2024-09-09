package net.echo.summer.config.annotations.inside;

import net.echo.summer.config.annotations.impl.ConfigEntry;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ConfigSection {
    String name();
    ConfigEntry[] entries();
}
