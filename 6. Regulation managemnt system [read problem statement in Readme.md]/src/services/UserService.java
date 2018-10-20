package services;

import java.sql.ResultSet;
import java.sql.SQLException;

import beans.UserBean;
import doa.DatabaseUtil;
import doa.DatabaseWrapper;

public class UserService {
	
	private DatabaseWrapper db;
	public UserService() {
		db = new DatabaseWrapper();
	}
	
	public UserBean userlogin(String mail ,String pass) throws SQLException {
		
		String query = "select * from users where mail_id='%s' and pass='%s'";
		
		query = String.format(query, mail,pass);
		
		UserBean user  = new UserBean();
		ResultSet rs = db.executeSqlQuerySelect(query);
		while(rs.next()) {
			user.setId(rs.getInt(1));
			user.setDept_id(rs.getInt(2));
			user.setEmail_id(rs.getString(3));
			return user;
		}
		return null;
	}
}
