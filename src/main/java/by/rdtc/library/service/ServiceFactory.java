package by.rdtc.library.service;

import by.rdtc.library.service.iface.AdminService;
import by.rdtc.library.service.iface.BookService;
import by.rdtc.library.service.iface.OrderService;
import by.rdtc.library.service.iface.UserService;
import by.rdtc.library.service.impl.AdminServiceImpl;
import by.rdtc.library.service.impl.BookServiceImpl;
import by.rdtc.library.service.impl.OrderServiceImpl;
import by.rdtc.library.service.impl.UserServiceImpl;

public final class ServiceFactory {
	private static final ServiceFactory instance=new ServiceFactory();
	
	private final UserService userService=new UserServiceImpl();
	private final BookService bookService=new BookServiceImpl();
	private final AdminService adminService=new AdminServiceImpl();
	private final OrderService orderService=new OrderServiceImpl();
	
	private ServiceFactory(){
		
	}

	public static ServiceFactory getInstance() {
		return instance;
	}

	public UserService getUserService() {
		return userService;
	}

	public BookService getBookService() {
		return bookService;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public OrderService getOrderService() {
		return orderService;
	}
	
	
	
		
}
