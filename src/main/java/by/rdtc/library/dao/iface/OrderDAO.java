package by.rdtc.library.dao.iface;

import java.util.List;

import by.rdtc.library.bean.Order;
import by.rdtc.library.dao.exception.DAOException;

public interface OrderDAO {
	List<Order> getOrders(int userId) throws DAOException;
	List<Order> getUsersOrders()  throws DAOException;
	void addOrder(int idUser, int idBook) throws DAOException;
	void confirmReturn(int idOrder) throws DAOException;
	void deliveryOrder(int idOrder) throws DAOException;
	void cancelOrder(int idUser, int idOrder, int idBook)throws DAOException;
	Order getOrderById(int idOrder) throws DAOException;
}
