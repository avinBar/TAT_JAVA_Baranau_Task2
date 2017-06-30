package by.rdtc.library.bean;

public class User {
	private String login;
	private String password;
	private String name;
	private String type;
	
	
	public User() {
	}

	public User(String login, String password, String name) {
		this.login = login;
		this.password = password;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
