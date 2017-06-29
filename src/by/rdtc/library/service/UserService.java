package by.rdtc.library.service;

import by.rdtc.library.bean.User;

public interface UserService {
	void signIn(String login,String password);
	void signOut(String login);
	void registration(User user);
}
