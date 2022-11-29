package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Db utility
public class UserSql {

	public static void DbConnection() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String driver="org.postgresql.Driver";
		String url="jdbc:postgresql://localhost:5432/postgres";
		String user="postgres";
		String pass ="123456789";
		{
		try {
	        Class.forName("org.postgresql.Driver");
	        con=DriverManager.getConnection(url,user,pass);
	        System.out.println("Opened database successfully");

	        Statement st = con.createStatement();
	        System.out.println("connection statement successfully");
//	        String sql = "INSERT INTO USERS (username,password,email,role_id) "
//	                + "VALUES ('joe','joe123','joe@email.com',2 );";
//	        String sql =" SELECT * from users";
//	        st.executeUpdate(sql);
	             
	        st.close();
	        con.close();
	     } catch ( Exception e ) {
	        System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	        System.exit(0);
	     }
		
		System.out.println("Records created successfully");
		
	}
	}

}
