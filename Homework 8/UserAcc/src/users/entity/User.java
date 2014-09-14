package users.entity;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private String username;
	private String email;
	private String password;
	private int role;
	
	public User(String username, String email, String password, boolean isAdmin) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = isAdmin?1:0;
	}
	
	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public int getRole() {
		return role;
	}
	
	public boolean tryLogin(String username, String password) {
		return this.username.equals(username) && this.password.equals(password);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof User) {
			return this.username.equals(((User) obj).getUsername());
		}	
		return false;
	}
	
	@Override
	public int hashCode() {
		return username.hashCode();
	}
}
