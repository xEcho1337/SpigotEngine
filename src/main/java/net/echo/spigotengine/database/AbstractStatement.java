package net.echo.spigotengine.database;

public class AbstractStatement {

    protected final TableSelection table;

    public AbstractStatement(TableSelection table) {
        this.table = table;
    }

    public TableSelection getTable() {
        return table;
    }
}
