package menu;

import static functional.Functional.*;

public class LibrarianMenu extends BaseMenu {

	void showMenu() {
		System.out.println("What you want:");
		System.out.println("Browse a catalog of books - choose 1");
		System.out.println("View the book - choose 2");
		System.out.println("Take book - choose 3");
		System.out.println("Return book - choose 4");
		System.out.println("Add book - choose 5");
		System.out.println("Add user - choose 6");
		System.out.println("Exit programm - choose 7");
		nextStep();
	}

	private void nextStep() {
		super.setChooseOperation(scanner.next());
		switch (getChooseOperation()) {
		case "1":
			printListBook();
			subMenu = new SubMenu(this);
			subMenu.showMenu();
			break;
		case "2":

			int id = chooseBook();
			printBookById(id);
			subMenu = new SubMenu(this);
			subMenu.showMenu();
			break;
		case "3":
			int idTakeBook = chooseBook();
			String message = ifPersonHaveMoreThanThreeBook(idTakeBook, person);
			printMessage(message);
			subMenu = new SubMenu(this);
			subMenu.showMenu();
			break;
		case "4":
			int idReturnBook = chooseBook();
			returnBook(idReturnBook, person);
			subMenu = new SubMenu(this);
			subMenu.showMenu();
			System.exit(0);
			break;
		case "5":
			addBookMenu = new AddBookMenu();
			addBookMenu.showMenu();
			break;
		case "6":
			addUserMenu = new AddUserMenu();
			addUserMenu.showMenu();
			break;
		case "7":
			System.exit(0);
			break;
		default:
			System.out.println("Wrong choose Try again");
			showMenu();
		}
	}

	private int chooseBook() {
		System.out.println("Enter book id");
		return scanner.nextInt();
	}

	private void printMessage(String msg) {
		System.out.println(msg);
	}

}
