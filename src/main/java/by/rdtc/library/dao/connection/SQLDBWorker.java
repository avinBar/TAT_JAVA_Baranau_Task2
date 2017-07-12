package by.rdtc.library.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import by.rdtc.library.dao.exception.DAOException;

public class SQLDBWorker implements DBWorker {
	private static final String URL = "jdbc:mysql://localhost:3306/elibrary";
	private static final String USER = "root";
	private static final String PASSWORD = "root777";
	
	private static final Logger log = Logger.getLogger(SQLDBWorker.class);

	private static SQLDBWorker instace = null;

	private SQLDBWorker() {

	}

	public static SQLDBWorker getInstance() throws DAOException {

		if (instace == null) {
			instace = new SQLDBWorker();
		}
		return instace;
	}

	public Connection getConnection() throws DAOException {
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			throw new DAOException("Failed to create the database connection");
		}
		return connection;
	}

	public void closeConnection(Connection connection, Statement st, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				log.log(Level.ERROR,"Exception while closing result set");
			}
		}
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				log.log(Level.ERROR, "Exception while closing statement");
			}
		}
		if (connection != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				log.log(Level.ERROR,"Exception while closing connection");
			}
		}
	}

	public void closeConnection(Connection connection, Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				log.log(Level.ERROR,"Exception while closing result set");
			}
		}
		
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				log.log(Level.ERROR,"Exception while closing connection");
			}
		}
	}
}
