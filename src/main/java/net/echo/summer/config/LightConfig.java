package net.echo.summer.config;

import net.echo.summer.config.annotations.Config;
import net.echo.summer.config.annotations.ConfigFile;
import net.echo.summer.config.utils.FileProcessor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public abstract class LightConfig {

    /***
     * Represents the Physical File
     */
    protected File configFile;

    /***
     * Represents the in Memory Configuration
     */
    public FileConfiguration fileConfiguration;

    /***
     * Register a basic Config that does not auto update and has no fields
     * @param plugin Your Plugin Instance
     */
    public void registerLightConfig(Plugin plugin){
        Class<?> clazz = this.getClass();

        if(BaseConfig.class.isAssignableFrom(clazz)) throw new IllegalArgumentException("The class must extends only one type!");

        if(!LightConfig.class.isAssignableFrom(clazz)) throw new IllegalArgumentException("The class must extends LightConfig!");

        if(!clazz.isAnnotationPresent(Config.class)) throw new IllegalArgumentException("The class must be annotated with @Config!");

        if(!clazz.isAnnotationPresent(ConfigFile.class)) throw new IllegalArgumentException("The class must be annotated with @ConfigFile!");

        String fileName = clazz.getAnnotation(ConfigFile.class).value();
        configFile = new File(plugin.getDataFolder(), fileName);

        if(!configFile.exists()){
            FileProcessor.saveResource(fileName, plugin);
        }
        fileConfiguration = YamlConfiguration.loadConfiguration(configFile);
    }

    /***
     * Save the in Memory configuration in the @File and Reload it
     */
    public void saveAndReload(){
        try{
            fileConfiguration.save(configFile);
            fileConfiguration = YamlConfiguration.loadConfiguration(configFile);
        }catch (IOException exception){
            exception.printStackTrace();
        }

    }

    /***
     * Simply reload the in Memory configuration reading @File
     */
    public void reload(){
        fileConfiguration = YamlConfiguration.loadConfiguration(configFile);
    }
}
