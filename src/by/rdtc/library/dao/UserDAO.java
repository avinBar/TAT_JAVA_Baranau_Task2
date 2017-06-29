package by.rdtc.library.dao;

import java.util.List;

import by.rdtc.library.bean.User;

public interface UserDAO {
	User signIn(String login, String password);
	void registration(User user);
	List<User> getAllUsers();
	List<User> getAllBannedUsers();
	void banUser(User user);
	void unbanUser(User user);
	void deleteUser(User user);
	
}
