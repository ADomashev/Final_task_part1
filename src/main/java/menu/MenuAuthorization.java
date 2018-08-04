package menu;

import static functional.Functional.*;

public class MenuAuthorization extends BaseMenu {

	private String login;
	private String password;

	public void showMenu() {
		System.out.println("Hello Sign in system please: ");
		System.out.println("Enter you login");
		setLogin(scanner.next());
		System.out.println("Enter you password: ");
		setPassword(scanner.next());
		setPerson(login, password);
		showNextMenu();
	}

	private void setLogin(String login) {
		this.login = login;
	}

	private void setPassword(String password) {
		this.password = password;
	}

	private void setPerson(String login, String password) {
		person = authorization(login, password);

	}

	private void showNextMenu() {
		System.out.println("AfterAUTORITY" + person);
		switch (person.getAccessLevel()) {
		case 1:
			userMenu = new UserMenu();
			userMenu.showMenu();
			break;
		case 2:
			librarianMenu = new LibrarianMenu();
			librarianMenu.showMenu();
			break;
		case 3:
			System.exit(0);
			break;
		default:
			System.out.println("Wrong choose Try again");
			showMenu();
		}
	}
}
