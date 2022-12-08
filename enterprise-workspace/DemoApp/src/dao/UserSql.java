package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import bean.Users;

/*
 * DB utility class
 * It contains all the functions for CRUD Operation for admin and normal users
 */
public class UserSql extends HttpServlet{

	private static final long serialVersionUID = 1L;
	static Connection con = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;

	//Database Connection method
	public static  int DbConnection(HttpServletRequest request) {
		
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

	        rs = ps.executeQuery();  
	        int i =0;
	        while(rs.next()){  
		         Users u=new Users(); //Columns are numbered from 1.
		       
		         u.setUser_id(rs.getInt(1));  
		         u.setUsername(rs.getString(2));  
		         u.setPassword(rs.getString(3));  
		         u.setEmail(rs.getString(4));  
		         u.setRole_id(rs.getInt(5));  
		         userList.add(u); 
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
		return returnLastInsertId;
		}
	}
	
	//insert data from Registeration page
	public int insertData(Users u) throws SQLException{
		int result = 0;
		try {
			String insertData = "insert into users values(?,?,?,?,?)";
			con = Connect.getPostGresConnection();
			String getId ="select user_id from users order by user_id desc";
			ps = con.prepareStatement(getId, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			//TYPE_SCROLL_SENSITIVE allows the cursor movement forward or backward to rs (the result set is scrollable and sensitive to database changes.)
			//setting result set concurrency values as CONCUR_UPDATABLE: the result set can be used to update the database.
			ResultSet rs = ps.executeQuery();
			rs.first();
			int count =rs.getInt(1);
		
			ps = con.prepareStatement(insertData);
			ps.setInt(1, count+1);
			ps.setString(2, u.getUsername());
			ps.setString(3, u.getPassword());
			ps.setString(4, u.getEmail());
			ps.setInt(5, u.getRole_id());
			result = ps.executeUpdate();	
		}
		catch (Exception ex) {
			System.out.println("Name" +u.getUser_id());
			ex.printStackTrace();
		}
		con.close();
		return result;
	}
	
	//checking if user is present
	public boolean checkUser(Users u) throws SQLException {
		String checkData = "Select * from users where username=?";
		
		con = Connect.getPostGresConnection();
		ps = con.prepareStatement(checkData);
		ps.setString(1, u.getUsername());
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
		
		con = Connect.getPostGresConnection();
		ps = con.prepareStatement(checkData);
		ps.setString(1, u.getUsername());
		ps.setString(2, u.getPassword());
		rs = ps.executeQuery();
		
		if (rs.next()) {
			return true;
		}
		return false;
	}
	
	//to get details of a particular user
	public static String[] singleView(Users u) throws ClassNotFoundException, SQLException {
		String data[] = null;
		int count = 0;
		con = Connect.getPostGresConnection();
		String sql = "select * from users where username=? and password=?";
		
		ps = con.prepareStatement(sql);
		ps.setString(1, u.getUsername());
		ps.setString(2, u.getPassword());
		rs = ps.executeQuery();
		count = rs.getMetaData().getColumnCount();
		System.out.println(count);
		while (rs.next()) {
			data = new String[count];
			for (int i = 0; i < count; i++) {
				data[i] = rs.getString(i + 1);
				System.out.println("list:"+data[i]);
			}
		}
		con.close();
		return data;
	}
	
	//update a user details from user side, and also from admin side
	public int updateData(Users u) throws SQLException {
		int result = 0;
		String updateData = "update users set password=?,email=? where username=?";
		
		con = Connect.getPostGresConnection();
		ps = con.prepareStatement(updateData);
		ps.setString(1, u.getPassword());
		ps.setString(2, u.getEmail());
		ps.setString(3, u.getUsername());
		result = ps.executeUpdate();
		con.close();
		return result;
	}
	
	//delete a user based on user_id
	public int deleteData(String id2) throws SQLException {
		int result = 0;
		String deleteData = "delete from users where user_id=?";
		
		con = Connect.getPostGresConnection();
		ps = con.prepareStatement(deleteData);
		ps.setInt(1, Integer.parseInt(id2));
		result = ps.executeUpdate();
		con.close();
		return result;
	}
	
	//getting details of a particular user from admin side login ; used for updating user from admin side
	public static String[] singleUserIDView(Users u, String id) throws ClassNotFoundException, SQLException {
		String data[] = null;
		int count = 0;
		con = Connect.getPostGresConnection();
		String sql = "select * from users where user_id=?";
		
		ps = con.prepareStatement(sql);
		ps.setInt(1, Integer.parseInt(id));
		rs = ps.executeQuery();
		
		count = rs.getMetaData().getColumnCount();
		while (rs.next()) {
			data = new String[count];
			for (int i = 0; i < count; i++) {
				data[i] = rs.getString(i + 1);
				System.out.println("list:"+data[i]);
			}
		}
		con.close();
		return data;
	}
}
