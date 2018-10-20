package beans;

public class UserBean {
	
	int id;
	String email_id, password;
	int dept_id;
	int dept_name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	public int getDept_name() {
		return dept_name;
	}
	public void setDept_name(int dept_name) {
		this.dept_name = dept_name;
	}
}
