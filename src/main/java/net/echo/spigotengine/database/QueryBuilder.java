package net.echo.spigotengine.database;

public class QueryBuilder {

    public static TableSelection table(String table) {
        return new TableSelection(table);
    }
}
