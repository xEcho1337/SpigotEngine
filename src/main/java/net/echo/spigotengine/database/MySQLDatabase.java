package net.echo.spigotengine.database;

import net.echo.spigotengine.database.connectors.DatabaseCredentials;
import net.echo.spigotengine.database.functions.StatementConsumer;

import java.sql.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

/**
 * An abstract base for MySQL databases.
 *
 * @author echo
 * @since 1.0.0
 */
public abstract class MySQLDatabase {

    private final DatabaseCredentials credentials;
    private final Executor executor;

	public MySQLDatabase(DatabaseCredentials credentials, Executor executor) {
		this.credentials = credentials;
        this.executor = executor;
	}

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                credentials.getJDBC(),
                credentials.getUsername(),
                credentials.getPassword()
        );
    }

    public Executor getExecutor() {
        return executor;
    }

    public <T> T execute(String query, StatementConsumer<T> function) {
        try (Connection connection = getConnection()) {
            try (Statement statement = connection.prepareStatement(query)) {
                return function.accept(statement);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }

        return null;
    }

    public <T> CompletableFuture<T> executeAsync(String query, StatementConsumer<T> function) {
        return CompletableFuture.supplyAsync(() -> execute(query, function), getExecutor());
    }

    public ResultSet executeQuery(String query, Object... params) {
        try (Connection connection = getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                setParameters(statement, params);

                return statement.executeQuery();
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }

        return null;
    }

    public CompletableFuture<ResultSet> executeQueryAsync(String query) {
        return CompletableFuture.supplyAsync(() -> executeQuery(query), getExecutor());
    }

    public int executeUpdate(String query, Object... params) {
        try (Connection connection = getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                setParameters(statement, params);

                return statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }

        return -1;
    }

    public CompletableFuture<Integer> executeUpdateAsync(String query, Object... params) {
        return CompletableFuture.supplyAsync(() -> executeUpdate(query, params), getExecutor());
    }

    private void setParameters(PreparedStatement statement, Object[] params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            statement.setObject(i + 1, params[i]);
        }
    }
}