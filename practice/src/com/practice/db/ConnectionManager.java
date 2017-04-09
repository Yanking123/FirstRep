package com.practice.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private final static String DRIVER = "com.mysql.jdbc.Driver";
	private final static String URL = "jdbc:mysql://localhost:3306/test";
	private final static String NAME = "root";
	private final static String PASSWD = "111111";
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static ConnectionManager cm;

	private ConnectionManager() {

	}

	public static ConnectionManager getInstance() {
		if (cm == null) {
			cm = new ConnectionManager();
		}
		return cm;
	}

	private ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

	public void before() {
		try {
			Connection connection = DriverManager.getConnection(URL, NAME, PASSWD);
			connection.setAutoCommit(false);
			threadLocal.set(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return threadLocal.get();
	}

	public void after() {
		Connection conn = getConnection();
		try {
			if (conn == null) {
				throw new SQLException("Á¬½ÓÎª¿Õ");
			}
			conn.commit();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
