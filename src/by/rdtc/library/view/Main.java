package by.rdtc.library.view;

import by.rdtc.library.controller.Controller;

public class Main {
	public static void main(String[] args) {
		Controller controller=new Controller();
		System.out.println(controller.executeTask("sign_in iceman...92 12345"));
		System.out.println(controller.executeTask("sign_in jjOP qwerty"));
		System.out.println(controller.executeTask("add_book Жизнь_игра И.Б.Крутой"));
	}
}
