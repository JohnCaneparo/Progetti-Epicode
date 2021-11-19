package it.epicode.esercitazione04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionHandler {

	private static final Logger logger = LoggerFactory.getLogger(ConnectionHandler.class);

	private static final String DRIVER_NAME = "org.postgresql.Driver";

	private String db_url;
	private String schema;
	private String username;
	private String password;

	private String connectionUrl = "";

	private Connection conn = null;

	public String getDB_URL() {
		return db_url;
	}

	public void setDB_URL(String db_url) {
		this.db_url = db_url;
	}

	public String getSCHEMA() {
		return schema;
	}

	public void setSCHEMA(String schema) {
		this.schema = schema;
	}

	public String getUSERNAME() {
		return username;
	}

	public void setUSERNAME(String username) {
		this.username = username;
	}

	public String getPASSWORD() {
		return password;
	}

	public void setPASSWORD(String password) {
		this.password = password;
	}

	public String getConnectionUrl() {
		return connectionUrl;
	}

	public void setConnectionUrl(String connectionUrl) {
		this.connectionUrl = connectionUrl;
	}

	public ConnectionHandler(String db_url, String schema, String username, String password) {
		this.db_url = db_url;
		this.schema = schema;
		this.username = username;
		this.password = password;
		setConnectionUrl("jdbc:postgresql://localhost:5432/" + this.db_url + "?currentSchema=" + this.schema + "&user=" + this.username
				+ "&password=" + this.password);
	}

	public Connection getConnection() throws SQLException, ClassNotFoundException {
		if (conn == null) {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(connectionUrl);
			logger.info("Ti sei connesso correttamente");
			return conn;
		} else
		return conn;
	}

	public void closeConnection() throws SQLException {
		conn.close();
		conn = null;
	}

	public PreparedStatement getPreparedStatement(String query) throws SQLException, ClassNotFoundException {
		PreparedStatement smt = getConnection().prepareStatement(query);
		return smt;
	}
	
}
