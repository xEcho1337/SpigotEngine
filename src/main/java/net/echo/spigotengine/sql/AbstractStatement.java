package net.echo.spigotengine.sql;

public class AbstractStatement {

    protected final TableSelection table;

    public AbstractStatement(TableSelection table) {
        this.table = table;
    }

    public TableSelection getTable() {
        return table;
    }
}
