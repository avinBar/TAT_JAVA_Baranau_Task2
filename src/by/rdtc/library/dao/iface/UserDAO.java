package by.rdtc.library.dao.iface;

import by.rdtc.library.bean.User;
import by.rdtc.library.dao.exception.DAOException;

public interface UserDAO {
	User signIn(String login, String password) throws DAOException;
	User getUserByLogin(String login) throws DAOException;
	void banUser(String login) throws DAOException;
	void unbanUser(String login) throws DAOException;
	void giveAdminRole(String login) throws DAOException;
	void register(User user) throws DAOException;
	void removeAdmin(String login)throws DAOException;
	 
}
