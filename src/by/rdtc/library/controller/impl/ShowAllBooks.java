package by.rdtc.library.controller.impl;



import java.util.List;

import by.rdtc.library.bean.Book;
import by.rdtc.library.controller.command.Command;
import by.rdtc.library.service.LibraryService;
import by.rdtc.library.service.ServiceFactory;
import by.rdtc.library.service.exception.ServiceException;

public class ShowAllBooks implements Command {

	@Override
	public String execute(String request) {
		String response=null;
		ServiceFactory serviceFactory=ServiceFactory.getInstance();
		LibraryService libraryService=serviceFactory.getLibraryService();
		List<Book>books;
		StringBuilder sb=new StringBuilder();
		try {
			books=libraryService.showAllBooks();
			for(Book book:books){
				sb.append(book.getId());
				sb.append(" ");
				sb.append(book.getTitle());
				sb.append(" by ");
				sb.append(book.getAuthor());
				sb.append("\n");
			}
			response=sb.toString();
		} catch (ServiceException e) {
			response="Error during show_books procedure";
		}
		return response;
	}
}
