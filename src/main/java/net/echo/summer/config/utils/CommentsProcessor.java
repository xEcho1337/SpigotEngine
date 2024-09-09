package net.echo.summer.config.utils;

import net.echo.summer.config.annotations.impl.ConfigEntry;
import net.echo.summer.config.annotations.inside.Comment;
import net.echo.summer.config.annotations.inside.CommentInLine;
import org.bukkit.configuration.file.FileConfiguration;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;

public class CommentsProcessor {

    public static void processComments(Field field, String path, FileConfiguration configuration){
        if(field.isAnnotationPresent(Comment.class)) {
            configuration.setComments(path, Arrays.asList(field.getAnnotation(Comment.class).value()));
        }
        if(field.isAnnotationPresent(CommentInLine.class)){
            configuration.setInlineComments(path, Arrays.asList(field.getAnnotation(CommentInLine.class).value()));
        }
    }
    public static void processEntryComments(String path, FileConfiguration configuration, ConfigEntry entry){
        if(entry.comment().isEmpty()) return;
        configuration.setInlineComments(path+"."+entry.key(),
                Collections.singletonList(entry.comment()));
    }
}
