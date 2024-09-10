package net.echo.spigotengine.sql.statement;

import net.echo.spigotengine.sql.AbstractStatement;
import net.echo.spigotengine.sql.TableSelection;

import java.util.ArrayList;
import java.util.List;

public class WhereStatement extends AbstractStatement {

    private final List<String> params;

    public WhereStatement(TableSelection table, String... params) {
        super(table);
        this.params = new ArrayList<>(List.of(params));
    }
}
