package net.echo.spigotengine.sql;

import net.echo.spigotengine.sql.statement.InsertStatement;
import net.echo.spigotengine.sql.statement.SelectStatement;
import net.echo.spigotengine.sql.statement.UpdateStatement;

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
