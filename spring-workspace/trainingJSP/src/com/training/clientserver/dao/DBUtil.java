/**
 * 
 */
package com.training.clientserver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.training.clientserver.dto.Login;
import com.training.clientserver.dto.Person;
import com.training.clientserver.dto.Trainee;

/**
 * @author Amrutha
 *
 */
public class DBUtil {
	public Login getUser(String userName, String password) throws SQLException {

		String sql = "Select username, password, display_name, user_type, person_person_id  from LOGIN_DETAILS" //
				+ " where username = ? and password= ?";
		Connection conn;
		try {
			conn = PostGresConnectionUtil.getPostGresConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, userName);
			pstm.setString(2, password);
			ResultSet rs = pstm.executeQuery();
			Login user;
			if (rs.next()) {
				String displayName = rs.getString("display_name");
				String userType = rs.getString("user_type");
				user = new Login();
				user.setUsername(userName);
				user.setPassword(password);
				user.setDisplayName(displayName);
				user.setUserType(userType);
				Person person = getPerson(conn, rs.getString("person_person_id"));
				user.setPerson(person);
				return user;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public Person getPerson(Connection conn, String personId) throws SQLException {
		String sql = "Select person_id, first_name, last_name, middle_name from PERSONS "//
				+ " where person_id = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, personId);

		ResultSet rs = pstm.executeQuery();
		Person person = null;
		if (rs.next()) {
			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");
			String middleName = rs.getString("middle_name");
			person = new Person();
			person.setFirstName(firstName);
			person.setLastName(lastName);
			person.setMiddleName(middleName);
			person.setPersonId(personId);
		}
		return person;
	}

	public static List<Trainee> getTraineesForTrainer(Connection conn, final String trainerPersonId)
			throws SQLException {
		String sql = "Select trainee_id, dept_dept_id, trainee_person_id from TRAINEES where trainer_person_id = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, trainerPersonId);
		ResultSet rs = pstm.executeQuery();
		List<Trainee> list = new ArrayList<Trainee>();
		while (rs.next()) {
			String traineeId = rs.getString("trainee_id");
			String deptId = rs.getString("dept_dept_id");
			String traineePersonId = rs.getString("trainee_person_id");
			Trainee trainee = new Trainee();
			trainee.setTraineeId(traineeId);
			trainee.setDeptId(deptId);
			trainee.setTraineePersonId(traineePersonId);
			trainee.setTrainerPersonId(trainerPersonId);
			list.add(trainee);
		}
		return list;
	}

//	public static Product findProduct(Connection conn, String code) throws SQLException {
//		String sql = "Select a.Code, a.Name, a.Price from Product a where a.Code=?";
//
//		PreparedStatement pstm = conn.prepareStatement(sql);
//		pstm.setString(1, code);
//
//		ResultSet rs = pstm.executeQuery();
//
//		while (rs.next()) {
//			String name = rs.getString("Name");
//			float price = rs.getFloat("Price");
//			Product product = new Product(code, name, price);
//			return product;
//		}
//		return null;
//	}
//
//	public static void updateProduct(Connection conn, Product product) throws SQLException {
//		String sql = "Update Product set Name =?, Price=? where Code=? ";
//
//		PreparedStatement pstm = conn.prepareStatement(sql);
//
//		pstm.setString(1, product.getName());
//		pstm.setFloat(2, product.getPrice());
//		pstm.setString(3, product.getCode());
//		pstm.executeUpdate();
//	}
//
//	public static void insertProduct(Connection conn, Product product) throws SQLException {
//		String sql = "Insert into Product(Code, Name,Price) values (?,?,?)";
//
//		PreparedStatement pstm = conn.prepareStatement(sql);
//
//		pstm.setString(1, product.getCode());
//		pstm.setString(2, product.getName());
//		pstm.setFloat(3, product.getPrice());
//
//		pstm.executeUpdate();
//	}
//
//	public static void deleteProduct(Connection conn, String code) throws SQLException {
//		String sql = "Delete From Product where Code= ?";
//
//		PreparedStatement pstm = conn.prepareStatement(sql);
//
//		pstm.setString(1, code);
//
//		pstm.executeUpdate();
//	}
}
