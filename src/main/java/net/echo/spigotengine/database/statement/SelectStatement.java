package net.echo.spigotengine.database.statement;

import net.echo.spigotengine.database.AbstractStatement;
import net.echo.spigotengine.database.TableSelection;

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
