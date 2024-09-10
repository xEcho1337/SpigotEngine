package net.echo.spigotengine.database;

import net.echo.spigotengine.database.statement.InsertStatement;
import net.echo.spigotengine.database.statement.SelectStatement;
import net.echo.spigotengine.database.statement.UpdateStatement;

public record TableSelection(String table) {

    public UpdateStatement update(String... params) {
        return new UpdateStatement(this, params);
    }

    public InsertStatement insert(String... params) {
        return new InsertStatement(this, params);
    }

    public SelectStatement select(String... columns) {
        return new SelectStatement(this, columns);
    }
}
