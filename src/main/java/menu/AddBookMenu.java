package menu;

import static functional.Functional.addBook;
import static functional.Functional.buildBook;
public class AddBookMenu extends BaseMenu {
	
	private static final String BOOK_ADDED_MESSAGE = "Book was added";
	
	@Override
	void showMenu() {
		System.out.println("Enter all info");
		System.out.println("Enter Book's name");
		String nameBook = scanner.next();
		System.out.println("Enter Author's name");
		String authorName = scanner.next();
		System.out.println("Enter Author's surname");
		String authorSurname = scanner.next();
		System.out.println("Enter Author's birthday : Example: yyyy.mm.dd");
		String date = scanner.next();

		
		book = buildBook(nameBook, authorName, authorSurname, date);
		if (addBook(book)) {
			printMessage(BOOK_ADDED_MESSAGE);
		}

		librarianMenu = new LibrarianMenu();
		librarianMenu.showMenu();
	}
	private void printMessage(String message) {

		System.out.println(message);

	}

}
