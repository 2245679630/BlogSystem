package csdn.model;

import java.io.Serializable;

public class User {

	private int u_id ;
	private String username;
	private String pwd;
	private String email;
	private String phone;
	private String qq;
	private String info;

	public User() {
		// super();
	}

	public User(int u_id, String username, String pwd, String email, String phone, String qq, String info) {
		// super();
		this.u_id = u_id;
		this.username = username;
		this.pwd = pwd;
		this.email = email;
		this.phone = phone;
		this.qq = qq;
		this.info = info;
	}

	public int getId() {
		return u_id;
	}

	public void setId(int id) {
		this.u_id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", username=" + username + ", pwd=" + pwd + ", email=" + email + ", phone="
				+ phone + ", qq=" + qq + ", info=" + info + "]";
	}

}
