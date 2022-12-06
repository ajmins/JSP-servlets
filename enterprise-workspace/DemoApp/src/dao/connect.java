package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//DBConnect file
public class Connect {

	public static Connection getPostGresConnection()
	{
		Connection con=null;
		String driver="org.postgresql.Driver";
		String url="jdbc:postgresql://localhost:5432/postgres";
		String user="postgres";
		String pass="123456789";
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,pass);
			Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from users"); 
//            while (rs.next()) {
//                System.out.println(rs.getString("user_id"));
//                System.out.println(rs.getString("username"));
//                System.out.println(rs.getString("email"));
//            }
			System.out.println("Connecting to db...");
		}
		catch(ClassNotFoundException|SQLException e)
		{
			e.printStackTrace();
		}
		return con;
	}
}
