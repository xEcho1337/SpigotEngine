package net.echo.spigotengine.database.connectors;

public class DatabaseCredentials {
	private final String host;
	private final int port;
	private final String database;
	private final String username;
	private final String password;

	public DatabaseCredentials(String host, int port, String database, String username, String password) {
		this.host = host;
		this.port = port;
		this.database = database;
		this.username = username;
		this.password = password;
	}

	public String getJDBC() {
		return "jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public String getDatabase() {
		return database;
	}

	public int getPort() {
		return port;
	}

	public String getHost() {
		return host;
	}
}