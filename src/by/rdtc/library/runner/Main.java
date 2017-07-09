package by.rdtc.library.runner;

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
	}
}
