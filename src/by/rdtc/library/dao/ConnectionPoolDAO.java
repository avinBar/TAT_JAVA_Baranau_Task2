package by.rdtc.library.dao;

import by.rdtc.library.dao.exception.ConnectionPoolException;

public interface ConnectionPoolDAO {
	void init() throws ConnectionPoolException;
	void destroy() throws ConnectionPoolException;
	
	
}
