package menu;

import java.util.Scanner;

import entity.Book;
import entity.Person;

public abstract class BaseMenu {

	private String chooseOperation;
	protected Scanner scanner;
	protected static Person person;
	protected UserMenu userMenu;
	protected LibrarianMenu librarianMenu;
	protected SubMenu subMenu;
	protected AddBookMenu addBookMenu;
	protected AddUserMenu addUserMenu;
	protected Book book;
	protected MenuAuthorization authorization;

	public BaseMenu() {
		scanner = new Scanner(System.in);
	}

	abstract void showMenu();

	public String getChooseOperation() {
		return chooseOperation;
	}

	public void setChooseOperation(String chooseOperation) {
		this.chooseOperation = chooseOperation;
	}
}
