package by.rdtc.library.dao.iface;

import java.util.List;

import by.rdtc.library.bean.User;
import by.rdtc.library.dao.exception.DAOException;

public interface UserDAO {
	User signIn(String login, String password) throws DAOException;
	void registration(User user) throws DAOException;
	User getUserByLogin(String login) throws DAOException;
	List<User> getAllUsers();
	List<User> getAllBannedUsers();
	void banUser(String login) throws DAOException;
	void unbanUser(String login) throws DAOException;
	void deleteUser(User user);
	void giveAdminRole(String login) throws DAOException;
	void takeAdminRole(String login) throws DAOException;
	 
}
