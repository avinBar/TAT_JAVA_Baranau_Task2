package by.rdtc.library.dao.iface;

import by.rdtc.library.dao.exception.DAOException;

public interface OrderDAO {

	void addOrder(int idUser, int idBook) throws DAOException;
	void confirmReturn(int idOrder) throws DAOException;
	void deliveryOrder(int idOrder) throws DAOException;
}
