package by.rdtc.library.service.iface;

import by.rdtc.library.service.exception.ServiceException;

public interface SuperAdminService {
	void takeAdminRole(String login) throws ServiceException;
}
