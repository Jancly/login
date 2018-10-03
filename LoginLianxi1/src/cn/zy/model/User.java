package cn.zy.model;

import java.io.Serializable;

import com.sun.jmx.snmp.Timestamp;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String  username;
	private String  password;
	private String  nikename;
	private Timestamp  createDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getNikename() {
		return nikename;
	}
	public void setNikename(String nikename) {
		this.nikename = nikename;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", nikename=" + nikename
				+ ", createDate=" + createDate + "]";
	}
	public User(int id, String username, String password, String nikename, Timestamp createDate) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.nikename = nikename;
		this.createDate = createDate;
	}
	public User(String username, String password, String nikename, Timestamp createDate) {
		super();
		this.username = username;
		this.password = password;
		this.nikename = nikename;
		this.createDate = createDate;
	}
	public User(String username, String password, String nikename) {
		super();
		this.username = username;
		this.password = password;
		this.nikename = nikename;
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public User() {
		super();
	}
	
	
	
	
	
	

}
