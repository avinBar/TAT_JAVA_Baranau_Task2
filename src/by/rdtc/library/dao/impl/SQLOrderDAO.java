package by.rdtc.library.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import by.rdtc.library.dao.exception.DAOException;
import by.rdtc.library.dao.iface.OrderDAO;
import by.rdtc.library.dao.pool.SQLDBWorker;

public class SQLOrderDAO implements OrderDAO {
	private final static String NEW_ORDER = "INSERT INTO orders (`u_id`, `b_id`, `order_date`) VALUES(?,?,?)";
	private final static String DELIVERY_ORDER = "UPDATE orders SET delivery_date=?  WHERE id_order=?";
	private final static String CONFIRM_RETURN = "UPDATE orders SET return_date=?  WHERE id_order=?";
	private final static String CANCEL_ORDER = "DELETE FROM orders where order_id = ? and u_id = ? and delivery_date = NULL";
	
	@Override
	public void addOrder(int idUser, int idBook) throws DAOException {
		Connection connection = null;
		PreparedStatement state = null;

		try {
			connection = SQLDBWorker.getInstance().getConnection();
			state = connection.prepareStatement(NEW_ORDER);
			state.setInt(1, idUser);
			state.setInt(2, idBook);
			state.setDate(3, new Date(System.currentTimeMillis()));
			state.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void confirmReturn(int idOrder) throws DAOException {
		Connection connection = null;
		PreparedStatement state = null;
		try {
			connection = SQLDBWorker.getInstance().getConnection();
			state = connection.prepareStatement(CONFIRM_RETURN);
			state.setDate(1, new Date(System.currentTimeMillis()));
			state.setInt(2, idOrder);
			state.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void deliveryOrder(int idOrder) throws DAOException {
		Connection connection = null;
		PreparedStatement state = null;
		try {
			connection = SQLDBWorker.getInstance().getConnection();
			state = connection.prepareStatement(DELIVERY_ORDER);
			state.setDate(1, new Date(System.currentTimeMillis()));
			state.setInt(2, idOrder);
			state.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void cancelOrder(int idUser, int idOrder) throws DAOException {
		Connection connection = null;
		PreparedStatement state = null;

		try {
			connection = SQLDBWorker.getInstance().getConnection();
			state = connection.prepareStatement(CANCEL_ORDER);
			state.setInt(1, idOrder);
			state.setInt(2, idUser);
			state.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
}
