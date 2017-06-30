package by.rdtc.library.dao.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import by.rdtc.library.dao.exception.DAOException;

public class SQLDBWorker  {
	private static final String URL="jdbc:mysql://localhost:3306/elibrary";
	private static final String USER="root";
	private static final String PASSWORD="root777";
	
	private static SQLDBWorker instace = null;
	
	private SQLDBWorker(){
		
	}


	public static SQLDBWorker getInstance() throws DAOException {

		if (instace == null) {
			instace = new SQLDBWorker();
		}
		return instace;
	}
	
	public Connection getConnection(){
		Connection connection=null;
			
			try {
				connection=DriverManager.getConnection(URL,USER,PASSWORD);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return connection;
		
	}
	


	
	

}
	
	

