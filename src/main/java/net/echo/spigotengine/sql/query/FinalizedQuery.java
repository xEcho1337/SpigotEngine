package net.echo.spigotengine.sql.query;

import java.sql.Connection;
import java.sql.Statement;
import java.util.function.Function;

public class FinalizedQuery<R> {

    private final String query;
    private final Function<Connection, Statement> statementFunction;

    public FinalizedQuery(String query, Function<Connection, Statement> statementFunction) {
        this.query = query;
        this.statementFunction = statementFunction;
    }

    public void execute(Connection connection) {

    }
}
