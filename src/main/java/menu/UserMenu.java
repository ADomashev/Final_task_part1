package menu;

import static functional.Functional.*;

public class UserMenu extends BaseMenu {

	void showMenu() {
		warningMessage();
		System.out.println("What you want:");
		System.out.println("Browse a catalog of books - choose 1");
		System.out.println("View the book - choose 2");
		System.out.println("Take book - choose 3");
		System.out.println("Return book - choose 4");
		System.out.println("Exit programm - choose ");
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

	private void warningMessage() {
		if (!findDelayBook(person)) {
			printMessage("you have overdue books");
		} else {
			printMessage("you have not overdue books");
		}
	}

	private void printMessage(String msg) {
		System.out.println(msg);
	}

}
