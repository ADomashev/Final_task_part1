package dao.daoimpl.dtbdao.abstractdao;

import java.util.List;

import entity.Author;
import entity.Book;
import entity.IssuedBook;
import entity.Person;
import util.Loader;

public class DaoAbstractCollection {
	private Loader loader;
	protected List<Book> listBook;
	protected List<Person> listPerson;
	protected List<IssuedBook> listIssueBook;
	protected List<Author> listAuthor;

	public DaoAbstractCollection() {
		loader = new Loader();
		listBook = loader.getListBook();
		listPerson = loader.getListPerson();
		listIssueBook = loader.getListIssueBook();
		listAuthor = loader.getListAuthor();
	}
	
	
}
