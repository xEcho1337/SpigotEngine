package net.echo.spigotengine.sql.statement;

import net.echo.spigotengine.sql.AbstractStatement;
import net.echo.spigotengine.sql.TableSelection;

import java.util.ArrayList;
import java.util.List;

public class SelectStatement extends AbstractStatement {

    private final List<String> columns;

    public SelectStatement(TableSelection table, String... columns) {
        super(table);
        this.columns = new ArrayList<>(List.of(columns));
    }

    public WhereStatement where(String... params) {
        return new WhereStatement(table, params);
    }
}
