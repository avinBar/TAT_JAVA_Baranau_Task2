package by.rdtc.library.dao.impl;

import java.util.List;

import by.rdtc.library.bean.User;
import by.rdtc.library.dao.UserDAO;

public class SQLUserDAO implements UserDAO {
	
	@Override
	public User signIn(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registration(User user) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllBannedUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void banUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unbanUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}
}
