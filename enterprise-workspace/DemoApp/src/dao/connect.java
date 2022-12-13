package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//DBConnect file
public class Connect {

	public static Connection getPostGresConnection(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("Enetering to db connection...");
		Connection con=null;
		String driver="org.postgresql.Driver";
		String url="jdbc:postgresql://localhost:5432/postgres";
		String user="postgres";
		String pass="123456789";
		try {
			System.out.println("Enetering to db connection try...");
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,pass);
			Statement st = con.createStatement();
			System.out.println("Enetering to db before query...");
          //  ResultSet rs = st.executeQuery("SELECT * from usertable"); 
			String sql ="CREATE TABLE IF NOT EXISTS userstable user_id serial primary key integer, username varchar(255),password varchar(255),email varchar(255),role_id integer)";
			ResultSet rs = st.executeQuery(sql);
            System.out.println("Enetering to db query...");
//            while (rs.next()) {
//                System.out.println(rs.getString("user_id"));
//                System.out.println(rs.getString("username"));
//                System.out.println(rs.getString("email"));
//            }
            System.out.println(rs);
			System.out.println("Connecting to db...");
			
		}
		catch(ClassNotFoundException|SQLException e)
		{
			System.out.println("Table not found");
			request.getRequestDispatcher("adminHome.jsp").forward(request, response);
			e.printStackTrace();
		}
		return con;
	}
}
