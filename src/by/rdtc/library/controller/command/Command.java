package by.rdtc.library.controller.command;

import java.util.Map;

public interface Command {

	public String execute(Map<String, String> params);
}
