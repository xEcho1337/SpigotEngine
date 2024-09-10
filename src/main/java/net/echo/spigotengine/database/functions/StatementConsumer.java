package net.echo.spigotengine.database.functions;

import java.sql.SQLException;
import java.sql.Statement;

public interface StatementConsumer<T> {

    T accept(Statement statement) throws SQLException;
}
