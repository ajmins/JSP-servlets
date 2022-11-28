/**
 * 
 */
package com.training.clientserver.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Amrutha
 *
 */
public class PostGresConnectionUtil {
	 public static Connection getPostGresConnection()
	         throws ClassNotFoundException, SQLException {
		 // Note: Change the connection parameters accordingly.
	     String hostName = "localhost";
	     String dbName = "trainingJSP";
	     String userName = "postgres";
	     String password = "pgadmin";
	     Class.forName("org.postgresql.Driver");
		 
	     String connectionURL = "jdbc:postgresql://" + hostName + ":5432/" + dbName;
	 
	     Connection conn = DriverManager.getConnection(connectionURL, userName,
	             password);
	     return conn;
	 }
	 
//	 public static Connection getPostGresConnection(String hostName, String dbName,
//	         String userName, String password) throws SQLException,
//	         ClassNotFoundException {
//	   
//	     Class.forName("org.postgresql.Driver");
//	 
//	     String connectionURL = "jdbc:postgresql://" + hostName + ":5432/" + dbName;
//	 
//	     Connection conn = DriverManager.getConnection(connectionURL, userName,
//	             password);
//	     return conn;
//	 }
}
