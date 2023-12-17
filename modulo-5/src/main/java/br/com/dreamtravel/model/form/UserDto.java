package br.com.dreamtravel.model.form;

import jakarta.validation.constraints.NotEmpty;

public class UserDto {
	
	@NotEmpty
	private String username;
	
	@NotEmpty
	private String password;
	
	public UserDto() {}

	public UserDto(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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

	@Override
	public String toString() {
		return "UserDto [username=" + username + ", password=" + password + "]";
	}
	
	
}
