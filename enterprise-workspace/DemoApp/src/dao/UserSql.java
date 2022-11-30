package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import bean.Users;

//Db utility
public class UserSql extends HttpServlet{

	public static void DbConnection(HttpServletRequest request) {
//		ServletContextEvent e = new ServletContextEvent((ServletContext)e);
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String driver="org.postgresql.Driver";
		String url="jdbc:postgresql://localhost:5432/postgres";
		String user="postgres";
		String pass ="123456789";
		{
			ArrayList<Users> userList=new ArrayList <Users>();  
		try {
	        Class.forName("org.postgresql.Driver");
	        con=DriverManager.getConnection(url,user,pass);
	        System.out.println("Opened database successfully");

	        ps = con.prepareStatement(" SELECT * from users");
	        System.out.println("connection statement successfully");
	        
	        
//	        String sql = "INSERT INTO USERS (username,password,email,role_id) "
//	                + "VALUES ('joe','joe123','joe@email.com',2 );";
//	        String sql =" SELECT * from users";
//	        st.executeUpdate(sql);
	           
	        
	        rs = ps.executeQuery();  
	        while(rs.next()){  
	         Users u=new Users(); 
	       //Columns are numbered from 1.
	         u.setUser_id(rs.getInt(1));  
	         u.setUsername(rs.getString(2));  
	         u.setPassword(rs.getString(3));  
	         u.setEmail(rs.getString(4));  
	         u.setRole_id(rs.getInt(5));  
	         userList.add(u);  
	        }  
	        ps.close();
	        con.close();
	     } catch ( Exception ex ) {
	        System.err.println( ex.getClass().getName()+": "+ ex.getMessage() );
	        System.exit(0);
	     }
		System.out.println("Records created successfully");
		request.setAttribute("data", userList);
		
	}
	}

}
