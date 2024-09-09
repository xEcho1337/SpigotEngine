package net.echo.summer.config.reader;

import net.echo.summer.config.reader.impl.MapImpl;
import org.bukkit.configuration.file.FileConfiguration;

import java.lang.reflect.Field;
import java.util.Map;

import static net.echo.summer.config.reader.impl.PrimitiveImpl.primitiveToObj;

public class ObjValue {

    public static Object toObjValue(FileConfiguration configuration, Field field, String path){
        if(field.getType().isPrimitive()){
            return primitiveToObj(field, configuration, path);
        }else if (Map.class.isAssignableFrom(field.getType())){
            return MapImpl.getMapFromConfiguration(configuration, path, field);
        }else{
            return configuration.getObject(path, field.getType());
        }
    }
}
