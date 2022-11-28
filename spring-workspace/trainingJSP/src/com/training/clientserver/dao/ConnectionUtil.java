/**
 * 
 */
package com.training.clientserver.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Amrutha
 *
 */
public class ConnectionUtil {
	private static Connection connection;

	public void setConnection(Connection connection) {
		ConnectionUtil.connection = connection;
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if (connection == null) {
			return PostGresConnectionUtil.getPostGresConnection();
		}
		return connection;

	}

	public static void close(Connection conn) {
		try {
			conn.close();
		} catch (Exception e) {
		}
	}

	public static void rollback(Connection conn) {
		try {
			conn.rollback();
		} catch (Exception e) {
		}
	}
}
