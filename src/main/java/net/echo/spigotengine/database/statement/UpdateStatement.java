package net.echo.spigotengine.database.statement;

import net.echo.spigotengine.database.AbstractStatement;
import net.echo.spigotengine.database.TableSelection;

import java.util.ArrayList;
import java.util.List;

public class UpdateStatement extends AbstractStatement {

    private final List<String> params;

    public UpdateStatement(TableSelection table, String... params) {
        super(table);
        this.params = new ArrayList<>(List.of(params));
    }

    public WhereStatement where(String... params) {
        return new WhereStatement(table, params);
    }
}
