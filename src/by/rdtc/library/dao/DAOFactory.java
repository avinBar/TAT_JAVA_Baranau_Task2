package by.rdtc.library.dao;

import by.rdtc.library.dao.iface.BookDAO;
import by.rdtc.library.dao.iface.OrderDAO;
import by.rdtc.library.dao.iface.UserDAO;
import by.rdtc.library.dao.impl.SQLBookDAO;
import by.rdtc.library.dao.impl.SQLOrderDAO;
import by.rdtc.library.dao.impl.SQLUserDAO;

public final class DAOFactory {
	private static final DAOFactory instance=new DAOFactory();
	
	private final BookDAO sqlBookImpl=new SQLBookDAO();
	private final UserDAO sqlUserImpl=new SQLUserDAO();
	private final OrderDAO sqlOrderImpl=new SQLOrderDAO();
	
	private DAOFactory(){
		
	}
	
	public static DAOFactory getInstance(){
		return instance;
	}
	
	public BookDAO getBookDAO(){
		return sqlBookImpl;
	}
	
	public UserDAO getUserDAO(){
		return sqlUserImpl;
	}

	public OrderDAO getOrderDAO() {
		return sqlOrderImpl;
	} 
}
