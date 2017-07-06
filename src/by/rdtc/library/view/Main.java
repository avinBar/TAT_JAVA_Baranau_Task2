package by.rdtc.library.view;

import java.util.Scanner;

import by.rdtc.library.controller.Controller;

public class Main {
	public static void main(String[] args) {
		Controller controller=new Controller();
		while(true){
		Scanner in = new Scanner(System.in);
		String task = in.nextLine();
		System.out.println(controller.executeTask(task));
		}
		//System.out.println(controller.executeTask("sign_in iceman...92 12345"));
		//System.out.println(controller.getUser().getLogin());
		//System.out.println(controller.executeTask("sign_in jjOP qwerty"));
		//System.out.println(controller.getUser().getLogin());
		//System.out.println(controller.executeTask("ban_user jjOP"));
		//System.out.println(controller.executeTask("all_books "));
		//System.out.println(controller.executeTask("order_book 4"));
	}
}
