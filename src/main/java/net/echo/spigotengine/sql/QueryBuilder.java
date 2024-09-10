package net.echo.spigotengine.sql;

public class QueryBuilder {

    public static TableSelection table(String table) {
        return new TableSelection(table);
    }
}
