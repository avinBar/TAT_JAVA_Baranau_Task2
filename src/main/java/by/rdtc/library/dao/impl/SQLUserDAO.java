package by.rdtc.library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.rdtc.library.bean.User;
import by.rdtc.library.dao.connection.SQLDBWorker;
import by.rdtc.library.dao.exception.DAOException;
import by.rdtc.library.dao.iface.UserDAO;

public class SQLUserDAO implements UserDAO {
	private final static String SIGN_IN = "SELECT u_id,u_login, u_type FROM user WHERE u_login=? and u_password=?";
	private final static String UPDATE_PROFILE = "UPDATE user SET u_name=?, u_surname=? WHERE u_id=?";
	private final static String USER_BY_LOGIN = "SELECT u_id,u_login, u_name, u_surname, u_type FROM user WHERE u_login=?";
	private final static String USER_BY_ID = "SELECT u_id,u_login, u_name, u_surname, u_type FROM user WHERE u_id=?";
	private final static String REGISTRATION = "INSERT INTO user (`u_login`, `u_password`, `u_name`, `u_surname`, `u_type`) VALUES(?,?,?,?,'user')";
	private final static String VIEW_ALL_USERS = "SELECT u_id,u_login, u_name, u_surname, u_type FROM user";
	private final static String CHANGE_USER_TYPE = "UPDATE user SET u_type=? WHERE u_login=? AND u_type=?";

	private final static int ZERO_AFFECTED_ROWS = 0;

	private final static String USER = "user";
	private final static String ADMIN = "admin";
	private final static String BANNED = "banned";
	private static final String U_ID = "u_id";
	private static final String U_LOGIN = "u_login";
	private static final String U_NAME = "u_name";
	private static final String U_SURNAME = "u_surname";
	private static final String U_TYPE = "u_type";

	@Override
	public User signIn(String login, String password) throws DAOException {
		Connection connection = null;
		PreparedStatement state = null;
		ResultSet rs = null;

		try {
			connection = SQLDBWorker.getInstance().getConnection();
			state = connection.prepareStatement(SIGN_IN);
			state.setString(1, login);
			state.setString(2, password);
			rs = state.executeQuery();

			if (!rs.next()) {
				return null;
			}
			User user = new User();
			user.setId(rs.getInt(U_ID));
			user.setLogin(rs.getString(U_LOGIN));
			user.setType(rs.getString(U_TYPE));
			return user;
		} catch (SQLException e) {
			throw new DAOException("Sign_in sql error", e);
		}finally {
			SQLDBWorker.getInstance().closeConnection(connection, state,rs);
		}
	}

	@Override
	public void register(User user) throws DAOException {
		Connection connection = null;
		PreparedStatement state = null;
		try {
			connection = SQLDBWorker.getInstance().getConnection();
			state = connection.prepareStatement(REGISTRATION);
			state.setString(1, user.getLogin());
			state.setString(2, user.getPassword());
			state.setString(3, user.getName());
			state.setString(4, user.getSurname());
			int update = state.executeUpdate();
			if (update > ZERO_AFFECTED_ROWS) {
				return;
			}
			throw new DAOException("Wrong user data");
		} catch (SQLException e) {
			throw new DAOException("Register sql error", e);
		}finally {
			SQLDBWorker.getInstance().closeConnection(connection, state);
		}
	}

	@Override
	public void editProfile(User user) throws DAOException {
		Connection connection = null;
		PreparedStatement state = null;

		try {
			connection = SQLDBWorker.getInstance().getConnection();
			state = connection.prepareStatement(UPDATE_PROFILE);
			state.setString(1, user.getName());
			state.setString(2, user.getSurname());
			state.setInt(3, user.getId());
			int update = state.executeUpdate();
			if (update > ZERO_AFFECTED_ROWS) {
				return;
			}
			throw new DAOException("Wrong user data");
		} catch (SQLException e) {
			throw new DAOException("Register sql error", e);
		}finally {
			SQLDBWorker.getInstance().closeConnection(connection, state);
		}
	}

	@Override
	public void banUser(String login) throws DAOException {
		Connection connection = null;
		PreparedStatement state = null;
		try {
			connection = SQLDBWorker.getInstance().getConnection();
			state = connection.prepareStatement(CHANGE_USER_TYPE);
			state.setString(1, BANNED);
			state.setString(2, login);
			state.setString(3, USER);
			int update = state.executeUpdate();
			if (update > ZERO_AFFECTED_ROWS) {
				return;
			}
			throw new DAOException("Wrong user data");
		} catch (SQLException e) {
			throw new DAOException("Ban sql error", e);
		}finally {
			SQLDBWorker.getInstance().closeConnection(connection, state);
		}
	}

	@Override
	public void unbanUser(String login) throws DAOException {
		Connection connection = null;
		PreparedStatement state = null;
		try {
			connection = SQLDBWorker.getInstance().getConnection();
			state = connection.prepareStatement(CHANGE_USER_TYPE);
			state.setString(1, USER);
			state.setString(2, login);
			state.setString(3, BANNED);
			int update = state.executeUpdate();
			if (update > ZERO_AFFECTED_ROWS) {
				return;
			}
			throw new DAOException("Wrong user data");
		} catch (SQLException e) {
			throw new DAOException("Unban sql error", e);
		}finally {
			SQLDBWorker.getInstance().closeConnection(connection, state);
		}
	}

	@Override
	public void giveAdminRole(String login) throws DAOException {
		Connection connection = null;
		PreparedStatement state = null;
		try {
			connection = SQLDBWorker.getInstance().getConnection();
			state = connection.prepareStatement(CHANGE_USER_TYPE);
			state.setString(1, ADMIN);
			state.setString(2, login);
			state.setString(3, USER);
			int update = state.executeUpdate();
			if (update > ZERO_AFFECTED_ROWS) {
				return;
			}
			throw new DAOException("Wrong user data");
		} catch (SQLException e) {
			throw new DAOException("Give Admin sql error", e);
		}finally {
			SQLDBWorker.getInstance().closeConnection(connection, state);
		}
	}

	@Override
	public void removeAdmin(String login) throws DAOException {
		Connection connection = null;
		PreparedStatement state = null;
		try {
			connection = SQLDBWorker.getInstance().getConnection();
			state = connection.prepareStatement(CHANGE_USER_TYPE);
			state.setString(1, USER);
			state.setString(2, login);
			state.setString(3, ADMIN);
			int update = state.executeUpdate();
			if (update > ZERO_AFFECTED_ROWS) {
				return;
			}
			throw new DAOException("Wrong user data");
		} catch (SQLException e) {
			throw new DAOException("Remove Admin sql error", e);
		}finally {
			SQLDBWorker.getInstance().closeConnection(connection, state);
		}
	}

	@Override
	public User getUserByLogin(String login) throws DAOException {
		Connection connection = null;
		PreparedStatement state = null;
		ResultSet rs = null;
		User user = null;
		try {
			connection = SQLDBWorker.getInstance().getConnection();
			state = connection.prepareStatement(USER_BY_LOGIN);
			state.setString(1, login);
			rs = state.executeQuery();
			
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt(U_ID));
				user.setLogin(rs.getString(U_LOGIN));
				user.setName(rs.getString(U_NAME));
				user.setSurname(rs.getString(U_SURNAME));
				user.setType(rs.getString(U_TYPE));
			} else {
				throw new DAOException("User doesn't exist");
			}
		} catch (SQLException e) {
			throw new DAOException("Get user sql error", e);
		} finally {
			SQLDBWorker.getInstance().closeConnection(connection, state, rs);
		}
		return user;
	}

	@Override
	public List<User> getAllUsers() throws DAOException {
		Connection connection = null;
		PreparedStatement state = null;
		ResultSet rs = null;
		try {
			connection = SQLDBWorker.getInstance().getConnection();
			state = connection.prepareStatement(VIEW_ALL_USERS);
			rs = state.executeQuery();
			List<User> users = new ArrayList<>();
			User user;
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt(U_ID));
				user.setLogin(rs.getString(U_LOGIN));
				user.setName(rs.getString(U_NAME));
				user.setSurname(rs.getString(U_SURNAME));
				user.setType(rs.getString(U_TYPE));
				users.add(user);
			}
			return users;
		} catch (SQLException e) {
			throw new DAOException("Get list of users sql error", e);
		}	finally {
			SQLDBWorker.getInstance().closeConnection(connection, state);
		}
	}

	@Override
	public User getUserById(int idUser) throws DAOException {
		Connection connection = null;
		PreparedStatement state = null;
		ResultSet rs = null;
		User user = null;
		try {
			connection = SQLDBWorker.getInstance().getConnection();
			state = connection.prepareStatement(USER_BY_ID);
			state.setInt(1, idUser);
			rs = state.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt(U_ID));
				user.setLogin(rs.getString(U_LOGIN));
				user.setName(rs.getString(U_NAME));
				user.setSurname(rs.getString(U_SURNAME));
				user.setType(rs.getString(U_TYPE));
			} else {
				throw new DAOException("User doesn't exist");
			}

		} catch (SQLException e) {
			throw new DAOException("Get user sql error", e);
		}finally {
			SQLDBWorker.getInstance().closeConnection(connection, state);
		}
		return user;
	}
}
