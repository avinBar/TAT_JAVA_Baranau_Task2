package by.rdtc.library.bean;

public class User {
	private int id;
	private String login;
	private String password;
	private String name;
	private String surname;
	private String govId;
	private String type;
	
	
	public User() {
		
	}

	public User(String login, String password, String name, String surname, String govId) {
		this.login = login;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.govId=govId;
	}
	
	
	public int getId() {
		return id;
	}
	

	public void setId(int id) {
		this.id = id;
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
	
	public void setPassword1(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
		
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getGovId() {
		return govId;
	}

	public void setGovId(String govId) {
		this.govId = govId;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
