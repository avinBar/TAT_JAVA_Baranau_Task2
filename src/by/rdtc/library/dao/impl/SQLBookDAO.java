package by.rdtc.library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.rdtc.library.bean.Book;
import by.rdtc.library.dao.exception.DAOException;
import by.rdtc.library.dao.iface.BookDAO;
import by.rdtc.library.dao.pool.SQLDBWorker;

public class SQLBookDAO implements BookDAO {
	private static final String SHOW_ALL_BOOKS="SELECT * FROM book";
	private static final String ADD_BOOK="INSERT INTO book (`b_title`, `b_author`) VALUES(?,?)";
	private static final String CHANGE_BOOK_STATUS="UPDATE book SET b_status=? WHERE b_id=?";
	private static final String DELETED="deleted";
	
	@Override
	public void addBook(Book book) throws DAOException {
		Connection connect=null;
		PreparedStatement state=null;
		try{
			connect=SQLDBWorker.getInstance().getConnection();
			state=connect.prepareStatement(ADD_BOOK);
			state.setString(1, book.getTitle());
			state.setString(2, book.getAuthor());
			state.executeUpdate();
		}catch(SQLException e){
			throw new DAOException(e);
		}
	}

	@Override
	public void deleteBook(int idBook) throws DAOException {
		Connection connect=null;
		PreparedStatement state=null;
		try{
			connect=SQLDBWorker.getInstance().getConnection();
			state=connect.prepareStatement(CHANGE_BOOK_STATUS);
			state.setString(1, DELETED);
			state.setInt(2, idBook);
			state.executeUpdate();
		}catch(SQLException e){
			throw new DAOException(e);
		}
		
	}


	@Override
	public List<Book> showAllBooks() throws DAOException {
		Connection connect=null;
		PreparedStatement state=null;
		ResultSet rs = null;
		try{
			connect=SQLDBWorker.getInstance().getConnection();
			state=connect.prepareStatement(SHOW_ALL_BOOKS);
			rs=state.executeQuery();
			List<Book> books=new ArrayList<>();
			Book book;
			while(rs.next()){
				book=new Book();
				book.setId(rs.getInt("b_id"));
				book.setTitle(rs.getString("b_title"));
				book.setAuthor(rs.getString("b_author"));
				books.add(book);
			}
			return books;
		}catch(SQLException e){
			throw new DAOException(e);
		}
	}
}
