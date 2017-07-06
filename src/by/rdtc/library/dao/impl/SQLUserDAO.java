package by.rdtc.library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import by.rdtc.library.bean.User;
import by.rdtc.library.dao.exception.DAOException;
import by.rdtc.library.dao.iface.UserDAO;
import by.rdtc.library.dao.pool.SQLDBWorker;

public class SQLUserDAO implements UserDAO {
	private final static String SIGN_IN="SELECT * FROM user WHERE u_login=? and u_password=?";
	private final static String USER_BY_LOGIN="SELECT * FROM user WHERE u_login=?";
	private final static String REGISTRATION="INSERT INTO user (`u_login`, `u_password`, `u_name`, `u_type`) VALUES(?,?,?,'user')";
	//private final static String VIEW_ALL_USERS =  "SELECT * FROM user";
	private final static String BAN_USER="UPDATE user SET u_type='banned' WHERE u_login=?";
	private final static String UNBAN_USER="UPDATE user SET u_type='user' WHERE u_login=?";
	private final static String GIVE_ADMIN_ROLE="UPDATE user SET u_type='admin' WHERE u_login=?";
	private final static String TAKE_ADMIN_ROLE="UPDATE user SET u_type='user' WHERE u_login=?";
	
	@Override
	public User signIn(String login, String password) throws DAOException {
		Connection connect=null;
		PreparedStatement state=null;
		ResultSet rs=null;
		
		try{
			connect=SQLDBWorker.getInstance().getConnection();
			state=connect.prepareStatement(SIGN_IN);
			state.setString(1, login);
			state.setString(2, password);
			rs=state.executeQuery();

            if (!rs.next()) {
                throw new DAOException("Not");
            }
            User user=new User();
            user.setId(rs.getInt("u_id"));
            user.setLogin(rs.getString("u_login"));
            user.setName(rs.getString("u_name"));
            user.setType(rs.getString("u_type"));
			return user;
		  } catch (SQLException e) {
	            throw new DAOException("Login sql error", e);
	        }
	    }

	@Override
	public void registration(User user) throws DAOException {
		Connection connect=null;
		PreparedStatement state=null;
		try{
				connect=SQLDBWorker.getInstance().getConnection();
				state=connect.prepareStatement(REGISTRATION);
				state.setString(1, user.getLogin());
				state.setString(2, user.getPassword());
				state.setString(3, user.getName());
				state.executeUpdate();
				
		  } catch (SQLException e) {
	            throw new DAOException("Login sql error", e);
	        }
	    }
		
	

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllBannedUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void banUser(String login) throws DAOException {
			Connection connect=null;
			PreparedStatement state=null;
			try{
				connect=SQLDBWorker.getInstance().getConnection();
				state=connect.prepareStatement(BAN_USER);
				state.setString(1, login);
				state.executeUpdate();
			}catch(SQLException e){
				throw new DAOException("Ban sql error",e);
			}
	}

	@Override
	public void unbanUser(String login) throws DAOException {
		Connection connect=null;
		PreparedStatement state=null;
		try{
			connect=SQLDBWorker.getInstance().getConnection();
		    state=connect.prepareStatement(UNBAN_USER);
			state.setString(1, login);
			state.executeUpdate();
		}catch(SQLException e){
			throw new DAOException("Unban sql error",e);
		}
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
	}

	@Override
	public void giveAdminRole(String login) throws DAOException {
		Connection connect=null;
		PreparedStatement state=null;
		try{
			connect=SQLDBWorker.getInstance().getConnection();
		    state=connect.prepareStatement(GIVE_ADMIN_ROLE);
			state.setString(1, login);
			state.executeUpdate();
		}catch(SQLException e){
			throw new DAOException("Give Admin sql error",e);
		}
	}

	@Override
	public void takeAdminRole(String login) throws DAOException {
		Connection connect=null;
		PreparedStatement state=null;
		try{
			connect=SQLDBWorker.getInstance().getConnection();
		    state=connect.prepareStatement(TAKE_ADMIN_ROLE);
			state.setString(1, login);
			state.executeUpdate();
		}catch(SQLException e){
			throw new DAOException("Take Admin sql error",e);
		}
	}

	@Override
	public User getUserByLogin(String login) throws DAOException {
		Connection connect=null;
		PreparedStatement state=null;
		ResultSet rs=null;
		try{
			 connect=SQLDBWorker.getInstance().getConnection();
			 state=connect.prepareStatement(USER_BY_LOGIN);
			 state.setString(1, login);
			 rs=state.executeQuery();
			 
			 User user=null;
			 if(rs.next()){
				 user=new User();
				 user.setLogin(rs.getString("u_login"));
				 user.setName(rs.getString("u_name"));
				 user.setType(rs.getString("u_type"));
			 }
			 return user;
			 
		}catch(SQLException e){
			throw new DAOException("User sql error");
		}
	}
}
