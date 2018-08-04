package functional;

import java.sql.Date;
import java.util.List;

import dao.daoimpl.collectiondao.AuthorCollectionDao;
import dao.daoimpl.collectiondao.BookCollectionDao;
import dao.daoimpl.collectiondao.IssueBookCollectionDao;
import dao.daoimpl.collectiondao.PersonCollectionDao;
import dao.daoimpl.dtbdao.AuthorDTBDao;
import dao.daoimpl.dtbdao.BookDTBDao;
import dao.daoimpl.dtbdao.IssuedBookDTBDao;
import dao.daoimpl.dtbdao.PersonDTBDao;

import dao.interfacedao.IAuthorDao;
import dao.interfacedao.IBookDao;
import dao.interfacedao.IIssuedBookDao;
import dao.interfacedao.IPersanDao;
import entity.Author;
import entity.Book;
import entity.IssuedBook;
import entity.Person;

public class Functional {
	private static final long DELAY_TIME = 2592000000L;

	private static final String MORE_THAN_THREE_BOOK = "You already have three book";
	private static final String BOOK_NOT_ISSUED_STATUS = "not issued";
	private static final String BOOK_ISSUED_STATUS = "issued";
	private static final String DEFAULT_STATUS_ISSUED_BOOK = "0000-00-00";

	static IBookDao bookDao;
	static IAuthorDao authorDao;
	static IIssuedBookDao issueBookDao;
	static IPersanDao personDao;

	static Author author;
	static Person person;
	static IssuedBook issuedBook;

	public static void initFunctionalOne() {

	}

	public static void initFunctionalDTB() {
		bookDao = new BookDTBDao();
		authorDao = new AuthorDTBDao();
		issueBookDao = new IssuedBookDTBDao();
		personDao = new PersonDTBDao();
	}

	public static void initFunctionalCollection() {
		bookDao = new BookCollectionDao();
		authorDao = new AuthorCollectionDao();
		issueBookDao = new IssueBookCollectionDao();
		personDao = new PersonCollectionDao();
	}

	public static Person authorization(String login, String password) {
		List<Person> persons = personDao.getAll();
		for (int i = 0; i < persons.size(); i++) {
			person = persons.get(i);
			if (person.getLogin().equals(login)) {
				return person;
			}
		}
		return person;
	}

	public static List<Book> printListBook() {
		List<Book> listbook = bookDao.getAll();
		for (Book book : listbook) {
			System.out.println(book);
		}
		return listbook;
	}

	public static void printBookById(int id) {
		System.out.println(bookDao.getEntityById(id));
	}

	public static boolean addBook(Book book) {
		author = book.getAuthor();
		if (authorDao.findAuthor(author)) {
			book.setAuthor(author);
			return bookDao.addEntity(book);

		} else {
			authorDao.addEntity(author);
			authorDao.findAuthor(author);
			book.setAuthor(author);
			return bookDao.addEntity(book);
		}
	}

	public static void getListReadBook() {
	}

	public static Person buildPersonByLibrarian(String name, String surName, String phoneNumber, String login,
			String password, String accessLevel) {
		Person person = new Person();
		person.setName(name);
		person.setSurname(surName);
		person.setPhoneNumber(Integer.valueOf(phoneNumber));
		person.setLogin(login);
		person.setPassword(password);
		person.setAccessLevel(Integer.valueOf(accessLevel));
		return person;
	}

	public static boolean addPerson(Person person) {
		boolean flag = personDao.loginExist(person.getLogin());
		if (!flag) {
			return personDao.addEntity(person);
		}
		return false;

	}

	public static void takeBook(Book book, Person person) {

		changePersonNumberIssueBook(person);
		changeBookStatusToIssue(book);
		IssuedBook issuedBook = buildIssueBook(book, person);
		issueBookDao.addEntity(issuedBook);
		personDao.update(person);
		bookDao.update(book);

	}

	public static void returnBook(int idBook, Person person) {
		Book book = bookDao.getEntityById(idBook);
		changeBookStatusToNotIssued(book);
		bookDao.updateAfterReturn(book);
		changePersonIssueBookandNumberIssuedParam(person);
		personDao.update(person);
		IssuedBook issuedBook = setReturnStatusIssuedBook(person, book);
		issueBookDao.update(issuedBook);
	}

	private static IssuedBook setReturnStatusIssuedBook(Person person, Book book) {
		List<IssuedBook> listIssuedBook = issueBookDao.getAll();
		IssuedBook issuedBookTmp = null;
		for (IssuedBook issuedBook : listIssuedBook) {
			if (issuedBook.getPersonId() == person.getId() & issuedBook.getBookId() == book.getId()
					& issuedBook.getReturnTime().equals(DEFAULT_STATUS_ISSUED_BOOK)) {
				issuedBookTmp = issuedBook;
				issuedBookTmp.setReturnTime(new Date(System.currentTimeMillis()).toString());
				return issuedBookTmp;
			}
		}
		return issuedBookTmp;
	}

	private static Book changeBookStatusToNotIssued(Book book) {
		book.setStatus(BOOK_NOT_ISSUED_STATUS);
		book.setIdPerson(0);
		return book;
	}

	private static Person changePersonIssueBookandNumberIssuedParam(Person person) {
		if (person.getNumberIssuedBook() > 0) {
			person.setNumberIssuedBook(person.getNumberIssuedBook() - 1);
			person.setNumberReadBook(person.getNumberReadBook() + 1);
		}
		return person;
	}

	public static String ifPersonHaveMoreThanThreeBook(int idBook, Person person) {
		if (person.getNumberIssuedBook() >= 3) {
			return MORE_THAN_THREE_BOOK;
		} else {
			return ifBookAlreadyIssued(idBook, person);
		}
	}

	private static String ifBookAlreadyIssued(int idBook, Person person) {
		Book book = bookDao.getEntityById(idBook);
		if (book.getStatus().equals(BOOK_NOT_ISSUED_STATUS) & findDelayBook(person)) {
			takeBook(book, person);
			return "Congratulations you took the book";
		} else
			return "This book already issued";
	}

	private static Person changePersonNumberIssueBook(Person person) {
		person.setNumberIssuedBook(person.getNumberIssuedBook() + 1);
		return person;
	}

	private static Book changeBookStatusToIssue(Book book) {
		book.setDate(new Date(System.currentTimeMillis()));
		book.setIdPerson(person.getId());
		book.setStatus(BOOK_ISSUED_STATUS);
		return book;
	}

	public static boolean findDelayBook(Person person) {
		System.out.println(person);
		List<Date> dates = bookDao.delayBook(person);
		for (Date date : dates) {
			Date delay = new Date((date.getTime() + DELAY_TIME));
			if (delay.before(new Date(System.currentTimeMillis()))) {
				return false;
			}
		}
		return true;
	}

	public static Book buildBook(String bookName, String authorName, String authorSurname, String date) {
		Book book = new Book();
		book.setBookName(bookName);
		book.setStatus(BOOK_NOT_ISSUED_STATUS);
		Author author = buildAuthor(authorName, authorSurname, date);
		book.setAuthor(author);
		return book;
	}

	private static IssuedBook buildIssueBook(Book book, Person person) {
		IssuedBook issuedBook = new IssuedBook();
		issuedBook.setBookId(book.getId());
		issuedBook.setDate(new Date(System.currentTimeMillis()));
		issuedBook.setPersonId(person.getId());
		issuedBook.setReturnTime(DEFAULT_STATUS_ISSUED_BOOK);
		return issuedBook;
	}

	private static Author buildAuthor(String authorName, String authorSurname, String date) {
		Author author = new Author();
		author.setName(authorName);
		author.setSurName(authorSurname);
		parseToDate(date, author);
		return author;
	}

	private static void parseToDate(String date, Author author) {
		String[] arrTmp = date.split("\\.|\\s|,|\\\\|:|;");
		int year = Integer.valueOf(arrTmp[0]);
		int month = Integer.valueOf(arrTmp[1]);
		int day = Integer.valueOf(arrTmp[2]);
		author.setBirthDay(year, month, day);
	}
}
