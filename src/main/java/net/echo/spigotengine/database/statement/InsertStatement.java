package net.echo.spigotengine.database.statement;

import net.echo.spigotengine.database.AbstractStatement;
import net.echo.spigotengine.database.TableSelection;

import java.util.ArrayList;
import java.util.List;

public class InsertStatement extends AbstractStatement {

    private final List<String> columns;

    public InsertStatement(TableSelection table, String... columns) {
        super(table);
        this.columns = new ArrayList<>(List.of(columns));
    }

    public ValuesStatement values(String... values) {
        return new ValuesStatement(table, values);
    }

    public static class ValuesStatement extends AbstractStatement {

        private final List<String> values;

        public ValuesStatement(TableSelection table, String... values) {
            super(table);
            this.values = new ArrayList<>(List.of(values));
        }
    }
}
