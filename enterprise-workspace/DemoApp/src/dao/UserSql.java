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
	static Connection con = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;

	public static  int DbConnection(HttpServletRequest request) {
//		ServletContextEvent e = new ServletContextEvent((ServletContext)e);
		
		String driver="org.postgresql.Driver";
		String url="jdbc:postgresql://localhost:5432/postgres";
		String user="postgres";
		String pass ="123456789";
		int returnLastInsertId = 0;
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
	      //  int[] userId = null;
	        int i =0;
	        while(rs.next()){  
		         Users u=new Users(); 
		       //Columns are numbered from 1.
		         u.setUser_id(rs.getInt(1));  
		         u.setUsername(rs.getString(2));  
		         u.setPassword(rs.getString(3));  
		         u.setEmail(rs.getString(4));  
		         u.setRole_id(rs.getInt(5));  
		         userList.add(u); 
		       //  userId[i]=u.getUser_id();
		         i++;
		         
	        } 
	        System.out.println(userList);

	        ps.close();
	        con.close();
	     } catch ( Exception ex ) {
	        System.err.println( ex.getClass().getName()+": "+ ex.getMessage() );
	        System.exit(0);
	     }
		System.out.println("Records created successfully");
		request.setAttribute("data", userList);
		System.out.println("entered after connection");
		return returnLastInsertId;
	}
	}
	
	//insert data  from Registeration page
	public int insertData(Users u) throws SQLException{
		int result = 0;
		try {
			
			String insertData = "insert into users values(?,?,?,?,?)";
			con = connect.getPostGresConnection();
			
			
			
			String getId ="select user_id from users order by user_id desc";
			ps = con.prepareStatement(getId, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			ResultSet rs = ps.executeQuery();
			rs.first();
			int count =rs.getInt(1);
		
			System.out.println(count);
			ps = con.prepareStatement(insertData);
			ps.setInt(1, count+1);
			
			
			ps.setString(2, u.getUsername());
			ps.setString(3, u.getPassword());
			
			ps.setString(4, u.getEmail());
			ps.setInt(5, u.getRole_id());
			
			System.out.println("Result: "+ result);
			
			
			System.out.println("Name" +u.getUsername());
			System.out.println("Name" +u.getEmail());
			System.out.println("Name" +u.getPassword());
			System.out.println("Name" +u.getRole_id());
			System.out.println("Name" +u.getUser_id());
			result = ps.executeUpdate();
			System.out.println("Result: "+ result);
			
			System.out.println("insert data method check2222");
		}
		catch (Exception ex) {
			System.out.println("Name" +u.getUser_id());
			ex.printStackTrace();
		}
	
		System.out.println("Result: "+ result);
		con.close();
		return result;
	}
	
	//checking if user is present
	public boolean checkUser(Users u) throws SQLException {
		System.out.println("NAme" +u.getUsername());
		String checkData = "Select * from users where username=?";
		con = connect.getPostGresConnection();

		ps = con.prepareStatement(checkData);
		ps.setString(1, u.getUsername());
		//ps.getpa
		rs = ps.executeQuery();

		if (!rs.next()) {
			System.out.println("true");
			return true;
			
		}
		System.out.println("false");
		return false;
	}
	//login user
	public boolean userLogin(Users u) throws SQLException {
		String checkData = "Select * from users where username=? and password=?";
		con = connect.getPostGresConnection();

		ps = con.prepareStatement(checkData);
		ps.setString(1, u.getUsername());
		ps.setString(2, u.getPassword());

		rs = ps.executeQuery();
		
		
		
		if (rs.next()) {
			return true;
		}
		return false;
	}
	public static String[] singleView(Users u) throws ClassNotFoundException, SQLException {
		String data[] = null;
		int count = 0;

		con = connect.getPostGresConnection();

		String sql = "select * from users where username=? and password=?";

		ps = con.prepareStatement(sql);

		ps.setString(1, u.getUsername());
		ps.setString(2, u.getPassword());
		

		rs = ps.executeQuery();

		
		
		count = rs.getMetaData().getColumnCount();
		//System.out.println(count);
		while (rs.next()) {
			data = new String[count];
			for (int i = 0; i < count; i++) {
				data[i] = rs.getString(i + 1);
				//System.out.println("list:"+data[i]);
			}
		}
		//System.out.println(data[count-1]);
		con.close();
		return data;
	}
	
}
