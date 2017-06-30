package by.rdtc.library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import by.rdtc.library.bean.Book;
import by.rdtc.library.dao.BookDAO;
import by.rdtc.library.dao.exception.DAOException;
import by.rdtc.library.dao.pool.SQLDBWorker;

public class SQLBookDAO implements BookDAO {
	private static final String ADD_BOOK="INSERT INTO book (`b_title`, `b_author`) VALUES(?,?)";
	@Override
	public void addBook(Book book) throws DAOException {
		Connection connect=null;
		PreparedStatement state=null;
		try{
			connect=SQLDBWorker.getInstance().getConnection();
			state=connect.prepareStatement(ADD_BOOK);
			state.setString(1, book.getTitle());
			state.setString(2, book.getAuthor());
			int i=state.executeUpdate();
		}catch(SQLException e){
			throw new DAOException(e);
		}
		
	}

	@Override
	public void deleteBook(int idBook) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMovie() {
		// TODO Auto-generated method stub
	}

}
