package by.rdtc.library.controller;

import org.testng.annotations.Test;

import by.rdtc.library.bean.User;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ControllerTest {
	private Controller controller;
	private User user;

	@BeforeMethod(groups = { "guest" })
	public void beforeGuestMethod() {
		controller = new Controller();
	}
	
	@BeforeMethod(groups = { "user" })
	public void beforeUserMethod() {
		controller = new Controller();
		user = new User();
		user.setId(6);
		user.setLogin("orderuser");
		user.setType("user");
		Controller.setUser(user);
	}
	
	@BeforeMethod(groups = { "admin" })
	public void beforeAdminMethod() {
		controller = new Controller();
		user = new User();
		user.setId(1);
		user.setLogin("donald44");
		user.setType("admin");
		Controller.setUser(user);
	}
	
	@BeforeMethod(groups = { "super_admin" })
	public void beforeSuperAdminMethod() {
		controller = new Controller();
		user = new User();
		user.setId(3);
		user.setLogin("supadmin");
		user.setType("super_admin");
		Controller.setUser(user);
	}

	@AfterMethod(groups = { "guest" })
	public void afterGuestMethod() {
		controller = null;
	}
	
	@AfterMethod(groups = { "user","admin","super_admin" })
	public void afterMethod() {
		user = null;
		controller = null;
	}
	
	@Test(groups={"guest"},dataProvider = "sign_in")
	public void tstSignIn(String request, String expResponse) {
		String response = controller.executeTask(request);
		Assert.assertEquals(response, expResponse);
	}

	@Test(groups={"guest"},dataProvider = "registration")
	public void tstRegistration(String request, String expResponse) {
		String response = controller.executeTask(request);
		Assert.assertEquals(response, expResponse);
	}
	
	@Test(groups={"user"},dataProvider = "order_book")
	public void tstOrderBook(String request, String expResponse) {
		String response = controller.executeTask(request);
		Assert.assertEquals(response, expResponse);
	}
	
	@Test(groups={"user"},dataProvider = "cancel_order")
	public void tstCancelOrder(String request, String expResponse) {
		String response = controller.executeTask(request);
		Assert.assertEquals(response, expResponse);
	}
	
	@Test(groups={"user"},dataProvider = "edit_profile")
	public void tstEditProfile(String request, String expResponse) {
		String response = controller.executeTask(request);
		Assert.assertEquals(response, expResponse);
	}
	
	@Test(groups={"user"}, dataProvider = "show_profile")
	public void tstShowProfile(String request, String expResponse) {
		String response = controller.executeTask(request);
		Assert.assertEquals(response, expResponse);
	}
	
	@Test(groups={"user"}, dataProvider = "view_book")
	public void tstViewBook(String request, String expResponse) {
		String response = controller.executeTask(request);
		Assert.assertEquals(response, expResponse);
	}
	
	@Test(groups="admin",dataProvider = "ban_user")
	public void tstBanUser(String request, String expResponse) {
		String response = controller.executeTask(request);
		Assert.assertEquals(response, expResponse);
	}
	
	@Test(groups={"admin"},dataProvider = "unban_user")
	public void tstUnBanUser(String request, String expResponse) {
		String response = controller.executeTask(request);
		Assert.assertEquals(response, expResponse);
	}
	
	@Test(groups={"admin"},dataProvider = "add_book")
	public void tstAddBook(String request, String expResponse) {
		String response = controller.executeTask(request);
		Assert.assertEquals(response, expResponse);
	}
	
	@Test(groups={"admin"},dataProvider = "confirm_return")
	public void tstConfirmReturn(String request, String expResponse) {
		String response = controller.executeTask(request);
		Assert.assertEquals(response, expResponse);
	}
	
	@Test(groups={"admin"},dataProvider = "delete_book")
	public void tstDeleteBook(String request, String expResponse) {
		String response = controller.executeTask(request);
		Assert.assertEquals(response, expResponse);
	}
	
	@Test(groups={"admin"},dataProvider = "delivery_order")
	public void tstDeliveryOrder(String request, String expResponse) {
		String response = controller.executeTask(request);
		Assert.assertEquals(response, expResponse);
	}
	
	@Test(groups={"admin"},dataProvider = "edit_book")
	public void tstEditBook(String request, String expResponse) {
		String response = controller.executeTask(request);
		Assert.assertEquals(response, expResponse);
	}
	
	@Test(groups={"admin"},dataProvider = "user_to_admin")
	public void tstUserToAdmin(String request, String expResponse) {
		String response = controller.executeTask(request);
		Assert.assertEquals(response, expResponse);
	}

	@Test(groups={"super_admin"},dataProvider = "admin_to_user")
	public void tstAdminToUser(String request, String expResponse) {
		String response = controller.executeTask(request);
		Assert.assertEquals(response, expResponse);
	}

	@DataProvider(name = "sign_in")
	public Object[][] dataForSignIn() {
		return new Object[][] { new Object[] { "sign_in&login=donald44&password=Me12345", "Welcome donald44" },
				new Object[] { "sign_in&login=kuzorka&password=Qwerty1", "Welcome kuzorka" },
				new Object[] { "sign_in&login=kuzorka&", "Wrong number of parameters" },
				new Object[] { "sign_in&login=kuzorka&password=", "Error during sign_in procedure" },
				new Object[] { "sign_in&&password=Qwerty1", "Wrong number of parameters" },
				new Object[] { "sign_in&", "Wrong number of parameters" },
				new Object[] { "sign_i&login=donald44&password=Me12345", "Wrong command" }, };
	}

	@DataProvider(name = "registration")
	public Object[][] dataForRegister() {
		return new Object[][] {
				new Object[] { "register&login=alfred&password=12345Va&name=Jack&surname=Forester",
						"Successful registration" },
				new Object[] { "register&login=alfred&password=12345Va&name=Jack&surname=Forester",
						"Error during registration procedure" },
				new Object[] { "register&login=jdp17&password=V9999a&name=Toto&", "Wrong number of parameters" },
				new Object[] { "register&login=jdp17&password=V9999a&&surname=Wolf", "Wrong number of parameters" },
				new Object[] { "register&login=jdp17&name=Toto&surname=Wolf", "Wrong number of parameters" },
				new Object[] { "register&password=V9999a&name=Toto&surname=Wolf", "Wrong number of parameters" },
				new Object[] { "register&", "Wrong number of parameters" }, };
	}

	@DataProvider(name = "edit_profile")
	public Object[][] dataForEditProfile() {
		return new Object[][] { //
				new Object[] { "edit_profile&name=EDITED&surname=EDITED", "Profile is updated successfully" },
				new Object[] { "edit_profile&name=&surname=", "Error during edit profile procedure" },
				new Object[] { "edit_profile&name=John&", "Wrong number of parameters" },
				new Object[] { "edit_profile&", "Wrong number of parameters" }, };
	}

	@DataProvider(name = "show_profile")
	public Object[][] dataForShowProfile() {
		return new Object[][] { //
				new Object[] { "show_profile&", "login=orderuser\nname=EDITED\nsurname=EDITED\ntype=user" }, };
	}
	
	@DataProvider(name = "view_book")
	public Object[][] dataForViewBook() {
		return new Object[][] { //
				new Object[] { "view_book&idBook=1", "id=1\ttitle=WorldWide\tauthor=Gibbons\tstatus=on_shelf\n" }, };
	}

	@DataProvider(name = "add_book")
	public Object[][] dataForAddBook() {
		return new Object[][] { //
				new Object[] { "add_book&title=WorldWide&author=Gibbons", "Successful registration" },
				new Object[] { "add_book&title=&author=", "Error during add book procedure" },
				new Object[] { "add_book&&author=Gibbons", "Wrong number of parameters" },
				new Object[] { "add_book&title=WorldWide&", "Wrong number of parameters" }, };
	}

	@DataProvider(name = "ban_user")
	public Object[][] dataForShowBook() {
		return new Object[][] { //
				new Object[] { "ban_user&login=kuzorka", "User kuzorka is banned" },
				new Object[] { "ban_user&login=donald44", "Error during ban procedure" },
				new Object[] { "ban_user&login=", "Error during ban procedure" },
				new Object[] { "ban_user&", "Wrong number of parameters" }, };
	}

	@DataProvider(name = "unban_user")
	public Object[][] dataForUnBan() {
		return new Object[][] { //
				new Object[] { "unban_user&login=Mich111", "User Mich111 is unbanned" },
				new Object[] { "unban_user&login=donald44", "Error during unban procedure" },
				new Object[] { "unban_user&login=", "Error during unban procedure" },
				new Object[] { "unban_user&", "Wrong number of parameters" }, };
	}

	@DataProvider(name = "user_to_admin")
	public Object[][] dataForUserToAdmin() {
		return new Object[][] { //
				new Object[] { "give_admin_role&login=user99", "User user99 is given admin role" },
				new Object[] { "give_admin_role&login=donald44", "Error during give admin role procedure" },
				new Object[] { "give_admin_role&login=", "Error during give admin role procedure" },
				new Object[] { "give_admin_role&", "Wrong number of parameters" }, };
	}

	@DataProvider(name = "delivery_order")
	public Object[][] dataForDeliveryOrder() {
		return new Object[][] { //
				new Object[] { "delivery_order&idOrder=1", "Book is delivered" },
				new Object[] { "delivery_order&idOrder=15", "Error during delivery order procedure" },
				new Object[] { "delivery_order&idOrder=", "Invalid parameters" },
				new Object[] { "delivery_order&", "Wrong number of parameters" }, };
	}

	@DataProvider(name = "confirm_return")
	public Object[][] dataForConfirmReturn() {
		return new Object[][] { //
				new Object[] { "return_book&idOrder=4", "Book is returned" },
				new Object[] { "return_book&idOrder=5", "Error during return book procedure" },
				new Object[] { "return_book&idOrder=", "Invalid parameters" },
				new Object[] { "return_book&", "Wrong number of parameters" }, };
	}

	@DataProvider(name = "delete_book")
	public Object[][] dataForDeleteBook() {
		return new Object[][] { //
				new Object[] { "delete_book&idBook=4", "Book is deleted" },
				new Object[] { "delete_book&idBook=5", "Error during delete book procedure" },
				new Object[] { "delete_book&idBook=", "Invalid parameters" },
				new Object[] { "delete_book&", "Wrong number of parameters" }, };
	}

	@DataProvider(name = "order_book")
	public Object[][] dataForOrderBook() {
		return new Object[][] { //
				new Object[] { "order_book&idBook=6", "The book is ordered" },
				new Object[] { "order_book&idBook=7", "Error during order book procedure" },
				new Object[] { "order_book&idBook=", "Invalid parameters" },
				new Object[] { "order_book&", "Wrong number of parameters" }, };
	}

	@DataProvider(name = "cancel_order")
	public Object[][] dataForCancelOrder() {
		return new Object[][] { //
				new Object[] { "cancel_order&idOrder=2", "Order is closed successfully" },
				new Object[] { "cancel_order&idOrder=3", "Error during cancel order procedure" },
				new Object[] { "cancel_order&idOrder=", "Invalid parameters" },
				new Object[] { "cancel_order&", "Wrong number of parameters" }, };
	}

	@DataProvider(name = "edit_book")
	public Object[][] dataForEditBook() {
		return new Object[][] { //
				new Object[] { "edit_book&idBook=9&title=SuccessEdit&author=Editor", "Book is edited" },
				new Object[] { "edit_book&idBook=9&title=&author=Editor", "Error during edit book procedure" },
				new Object[] { "edit_book&idBook=9&title=&author=", "Error during edit book procedure" },
				new Object[] { "edit_book&", "Wrong number of parameters" }, };
	}
	
	@DataProvider(name = "admin_to_user")
	public Object[][] dataForRemoveAdmin() {
		return new Object[][] { //
				new Object[] { "remove_admin&login=admintouser", "User admintouser is deprived of admin role" },
				new Object[] { "remove_admin&login=orderuser", "Error during adminToUser procedure" },
				new Object[] { "remove_admin&login=", "Error during adminToUser procedure" },
				new Object[] { "remove_admin&", "Wrong number of parameters" },};
	}

}
