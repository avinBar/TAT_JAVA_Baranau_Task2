package by.rdtc.library.dao.connection;

import java.sql.Connection;

import by.rdtc.library.dao.exception.DAOException;

public interface DBWorker {
	public Connection getConnection() throws DAOException;
}
