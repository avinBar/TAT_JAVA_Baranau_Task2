package by.rdtc.library.controller.impl.guest;



import java.util.List;
import java.util.Map;

import by.rdtc.library.bean.Book;
import by.rdtc.library.controller.command.Command;
import by.rdtc.library.service.ServiceFactory;
import by.rdtc.library.service.exception.ServiceException;
import by.rdtc.library.service.iface.LibraryService;

public class ShowBooks implements Command {

	@Override
	public String execute(Map<String,String> params) {
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
			response="Error during show books procedure";
		}
		return response;
	}
}
