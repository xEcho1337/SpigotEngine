package net.echo.spigotengine.database.statement;

import net.echo.spigotengine.database.AbstractStatement;
import net.echo.spigotengine.database.TableSelection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class WhereStatement extends AbstractStatement {

    private final List<String> params;

    public WhereStatement(TableSelection table, String... params) {
        super(table);
        this.params = new ArrayList<>(List.of(params));
    }
}
