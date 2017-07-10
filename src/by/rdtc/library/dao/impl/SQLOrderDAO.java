package by.rdtc.library.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.rdtc.library.bean.Order;
import by.rdtc.library.dao.connection.SQLDBWorker;
import by.rdtc.library.dao.exception.DAOException;
import by.rdtc.library.dao.iface.OrderDAO;

public class SQLOrderDAO implements OrderDAO {
	private final static String NEW_ORDER = "INSERT INTO orders (`u_id`, `b_id`) VALUES(?,?)";
	private final static String DELIVERY_ORDER = "UPDATE orders SET delivery_date=?  WHERE o_id=? and return_date IS NULL";
	private final static String CONFIRM_RETURN = "UPDATE orders SET return_date=?  WHERE o_id=? and delivery_date IS NOT NULL";
	private final static String GET_ORDER_BY_ID="SELECT o_id, u_id, b_id, delivery_date, return_date FROM orders WHERE o_id=?";
	private final static String CANCEL_ORDER = "DELETE FROM orders WHERE o_id = ? and u_id=? and delivery_date IS NULL";
	private final static String VIEW_ORDERS = "SELECT o_id, u_id, b_id, delivery_date, return_date FROM orders WHERE u_id=?";
	private final static String VIEW_USERS_ORDERS = "SELECT o_id, u_id, b_id, delivery_date, return_date FROM orders";
	private final static String NEW_BOOK_STATUS = "UPDATE book SET b_status=? WHERE b_id=?";
	private final static String CHANGE_BOOK_STATUS = "UPDATE book SET b_status=? WHERE b_id IN (SELECT b_id FROM orders WHERE o_id=?)";

	private final static int ZERO_AFFECTED_ROWS = 0;

	private final static String ON_SHELF = "on_shelf";
	private final static String RESERVED = "reserved";
	private final static String TAKEN_AWAY = "taken_away";

	@Override
	public void addOrder(int idUser, int idBook) throws DAOException {
		Connection connection = null;
		PreparedStatement state = null;

		try {
			connection = SQLDBWorker.getInstance().getConnection();
			state = connection.prepareStatement(NEW_ORDER);
			state.setInt(1, idUser);
			state.setInt(2, idBook);
			int update = state.executeUpdate();
			if (update > ZERO_AFFECTED_ROWS) {
				state = connection.prepareStatement(NEW_BOOK_STATUS);
				state.setString(1, RESERVED);
				state.setInt(2, idBook);
				state.executeUpdate();
				return;
			}
			throw new DAOException("Wrong order data");
		} catch (SQLException e) {
			throw new DAOException("Add order sql error", e);
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
			int update = state.executeUpdate();
			if (update > ZERO_AFFECTED_ROWS) {
				state = connection.prepareStatement(CHANGE_BOOK_STATUS);
				state.setString(1, ON_SHELF);
				state.setInt(2, idOrder);
				state.executeUpdate();
				return;
			}
			throw new DAOException("Wrong order data");
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
			int update = state.executeUpdate();
			if (update > ZERO_AFFECTED_ROWS) {
				state = connection.prepareStatement(CHANGE_BOOK_STATUS);
				state.setString(1, TAKEN_AWAY);
				state.setInt(2, idOrder);
				state.executeUpdate();
				return;
			}
			throw new DAOException("Wrong order data");
		} catch (SQLException e) {
			throw new DAOException("Delivery order sql error", e);
		}
	}

	@Override
	public void cancelOrder(int idUser, int idOrder, int idBook) throws DAOException {
		Connection connection = null;
		PreparedStatement state = null;

		try {
			connection = SQLDBWorker.getInstance().getConnection();
			state = connection.prepareStatement(CANCEL_ORDER);
			state.setInt(1, idOrder);
			state.setInt(2, idUser);
			int update = state.executeUpdate();
			if (update > ZERO_AFFECTED_ROWS) {
				state = connection.prepareStatement(NEW_BOOK_STATUS);
				state.setString(1, ON_SHELF);
				state.setInt(2, idBook);
				state.executeUpdate();
				return;
			}
			throw new DAOException("Wrong order data");
		} catch (SQLException e) {
			throw new DAOException("Cancel order sql error", e);
		}
	}

	@Override
	public List<Order> getOrders(int idUser) throws DAOException {
		Connection connect=null;
		PreparedStatement state=null;
		ResultSet rs = null;
		try{
			connect=SQLDBWorker.getInstance().getConnection();
			state=connect.prepareStatement(VIEW_ORDERS);
			state.setInt(1, idUser);
			rs=state.executeQuery();
			List<Order> orders=new ArrayList<>();
			Order order;
			while(rs.next()){
				order=new Order();
				order.setId(rs.getInt("o_id"));
				order.setIdUser(rs.getInt("u_id"));
				order.setIdBook(rs.getInt("b_id"));
				order.setDeliveryDate(rs.getDate("delivery_date"));
				order.setReturnDate(rs.getDate("return_date"));
				orders.add(order);
			}
			return orders;
		}catch(SQLException e){
			throw new DAOException("Get orders sql error");
		}
	}

	@Override
	public List<Order> getUsersOrders() throws DAOException {
		Connection connect=null;
		PreparedStatement state=null;
		ResultSet rs = null;
		try{
			connect=SQLDBWorker.getInstance().getConnection();
			state=connect.prepareStatement(VIEW_USERS_ORDERS);
			rs=state.executeQuery();
			List<Order> orders=new ArrayList<>();
			Order order;
			while(rs.next()){
				order=new Order();
				order.setId(rs.getInt("o_id"));
				order.setIdUser(rs.getInt("u_id"));
				order.setIdBook(rs.getInt("b_id"));
				order.setDeliveryDate(rs.getDate("delivery_date"));
				order.setReturnDate(rs.getDate("return_date"));
				orders.add(order);
			}
			return orders;
		}catch(SQLException e){
			throw new DAOException("Get list of users orders sql error");
		}
		
	}

	@Override
	public Order getOrderById(int idOrder) throws DAOException {
		Connection connect=null;
		PreparedStatement state=null;
		ResultSet rs = null;
		
		try{
			connect=SQLDBWorker.getInstance().getConnection();
			state=connect.prepareStatement(GET_ORDER_BY_ID);
			state.setInt(1, idOrder);
			rs=state.executeQuery();
			Order order;
			if(!rs.next()){
				throw new DAOException("No order matching query");
			}
				order=new Order();
				order.setId(rs.getInt("o_id"));
				order.setIdUser(rs.getInt("u_id"));
				order.setIdBook(rs.getInt("b_id"));
				order.setDeliveryDate(rs.getDate("delivery_date"));
				order.setReturnDate(rs.getDate("return_date"));
				return order;
		}catch(SQLException e){
			throw new DAOException("Get order sql error");
		}
	}
}
