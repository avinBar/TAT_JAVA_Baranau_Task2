package by.rdtc.library.service;

import by.rdtc.library.service.iface.AdminService;
import by.rdtc.library.service.iface.LibraryService;
import by.rdtc.library.service.iface.SuperAdminService;
import by.rdtc.library.service.iface.UserService;
import by.rdtc.library.service.impl.AdminServiceImpl;
import by.rdtc.library.service.impl.LibraryServiceImpl;
import by.rdtc.library.service.impl.SuperAdminServiceImpl;
import by.rdtc.library.service.impl.UserServiceImpl;

public final class ServiceFactory {
	private static final ServiceFactory instance=new ServiceFactory();
	
	private final UserService userService=new UserServiceImpl();
	private final LibraryService libraryService=new LibraryServiceImpl();
	private final AdminService adminService=new AdminServiceImpl();
	private final SuperAdminService superAdminService=new SuperAdminServiceImpl();
	
	private ServiceFactory(){
		
	}

	public static ServiceFactory getInstance() {
		return instance;
	}

	public UserService getUserService() {
		return userService;
	}

	public LibraryService getLibraryService() {
		return libraryService;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public SuperAdminService getSuperAdminService() {
		return superAdminService;
	}
	
	
	
		
}
