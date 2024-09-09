package net.echo.summer.config;

import net.echo.summer.config.annotations.CleanUpdate;
import net.echo.summer.config.annotations.Config;
import net.echo.summer.config.annotations.ConfigFile;
import net.echo.summer.config.annotations.Header;
import net.echo.summer.config.utils.FieldProcessor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.List;

public abstract class BaseConfig {

    /***
     * Represents the Physical File
     */
    protected File configFile;

    /***
     * Represents the in Memory Configuration
     */
    public FileConfiguration fileConfiguration;

    /***
     * Register and update your configuration and will also add non-existing values into @File
     * @param plugin Your Plugin Instance
     */
    public void registerConfig(Plugin plugin){
        Class<?> clazz = this.getClass();

        if(LightConfig.class.isAssignableFrom(clazz)) throw new IllegalArgumentException("The class must extends only one type!");

        if(!BaseConfig.class.isAssignableFrom(clazz)) throw new IllegalArgumentException("The class must extends BaseConfig!");

        if(!clazz.isAnnotationPresent(Config.class)) throw new IllegalArgumentException("The class must be annotated with @Config!");

        if(!clazz.isAnnotationPresent(ConfigFile.class)) throw new IllegalArgumentException("The class must be annotated with @ConfigFile!");

        String fileName = clazz.getAnnotation(ConfigFile.class).value();
        configFile = new File(plugin.getDataFolder(), fileName);

        if(configFile.exists() && clazz.isAnnotationPresent(CleanUpdate.class)){
            handleCleanUpdate(configFile);
            return;
        }

        fileConfiguration = YamlConfiguration.loadConfiguration(configFile);
        try{
            FieldProcessor.handleFields(fileConfiguration, this);
            
            if (clazz.isAnnotationPresent(Header.class)){
                fileConfiguration.options().header(String.join("\n", clazz.getAnnotation(Header.class).value()));
            }
            
            fileConfiguration.save(configFile);
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }


    /***
     * Simply reload the in Memory configuration reading @File
     */
    public void reload(){
        fileConfiguration = YamlConfiguration.loadConfiguration(configFile);
        FieldProcessor.handleFields(fileConfiguration, this);
        try {
            fileConfiguration.save(configFile);
        } catch (IOException e) {
            throw new RuntimeException("Error while saving an reloading " + configFile.getName());
        }
    }

    /***
     * By Cloning and Comparing the Fields, it will override the
     * existing file with a new one containing values from old file!
     * This way we can ensure that entries no longer existing will be removed
     * @param configFile Existing File
     */
    private void handleCleanUpdate(File configFile){
        FileConfiguration oldConfig = YamlConfiguration.loadConfiguration(configFile);
        FieldProcessor.handleFields(oldConfig, this);

        FileConfiguration newConfig = new YamlConfiguration();
        FieldProcessor.writeFieldsToFile(newConfig, this);

        if(this.getClass().isAnnotationPresent(Header.class)) {
            fileConfiguration.options().header(String.join("\n", this.getClass().getAnnotation(Header.class).value()));
        }
        
        configFile.delete();
        try {
            newConfig.save(configFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        fileConfiguration = newConfig;
    }

}
