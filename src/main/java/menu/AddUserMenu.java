package menu;

import static functional.Functional.*;

public class AddUserMenu extends BaseMenu {
	
	private static final String MESSAGE_PERSON_ALREADY_EXIST = "Login already exist. "+"\n"+" Change login";
	private static final String PERSON_ADDED_MESSAGE = "Person was added";
	@Override
	void showMenu() {
		System.out.println("Enter all info");
		System.out.println("Enter User's name");
		String nameUser = scanner.next();
		
		System.out.println("Enter User's surname");
		String userSurname = scanner.next();
		
		System.out.println("Enter User's phone number");
		String phoneNumber = scanner.next();
		
		System.out.println("Enter User's login ");
		String login = scanner.next();
		
		printMessage("Enter User's password");
		String password = enterPassword();
		
		System.out.println("Enter User's access level");
		String accessLevel = scanner.next();
		
		
		
		if (addPerson(buildPersonByLibrarian(nameUser, userSurname,phoneNumber,login,password,accessLevel))) {
			printMessage(PERSON_ADDED_MESSAGE);
		}else {
			printMessage(MESSAGE_PERSON_ALREADY_EXIST);
		}

		librarianMenu = new LibrarianMenu();
		librarianMenu.showMenu();
	}

	private void printMessage(String message) {

		System.out.println(message);

	}

	private String enterPassword() {

		String pass = scanner.next();
		if (validPassword(pass)) {
			return pass;
		}else
		return returnMessageInvalidPass();
	}

	private boolean validPassword(String pass) {
		if (pass.length() > 6 & containsNumber(pass)) {
			return true;
		}else
		return false;
	}

	private boolean containsNumber(String pass) {
		char[] arrTmp = pass.toCharArray();
		for (int i = 0; i < arrTmp.length; i++) {
			if (Character.isDigit(arrTmp[i])) {
				return true;
			}
		}
		return false;
	}

	private String returnMessageInvalidPass() {
		printMessage("Invalid password try again");
		return enterPassword();
	}

}
