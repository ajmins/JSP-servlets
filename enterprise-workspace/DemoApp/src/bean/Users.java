package bean;

//table 
public class Users {  
private int user_id,role_id;  
private String username,password,email;

public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public int getRole_id() {
	return role_id;
}
public void setRole_id(int role_id) {
	this.role_id = role_id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Override
public String toString() {
	return "Users [user_id=" + user_id + ", role_id=" + role_id + ", username=" + username + ", password=" + password
			+ ", email=" + email + "]";
}  
  

  
}  