package by.rdtc.library.dao;

import java.util.List;

import by.rdtc.library.bean.User;
import by.rdtc.library.dao.exception.DAOException;

public interface UserDAO {
	User signIn(String login, String password) throws DAOException;
	void registration(User user) throws DAOException;
	List<User> getAllUsers();
	List<User> getAllBannedUsers();
	void banUser(User user);
	void unbanUser(User user);
	void deleteUser(User user);
	
}
