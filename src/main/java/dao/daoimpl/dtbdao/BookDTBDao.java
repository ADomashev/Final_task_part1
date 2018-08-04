package dao.daoimpl.dtbdao;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.daoimpl.dtbdao.abstractdao.DaoAbstractSQL;
import dao.interfacedao.IBookDao;
import entity.Author;
import entity.Book;
import entity.Person;

public class BookDTBDao extends DaoAbstractSQL implements IBookDao {

	private static final String LIST_BOOK = "SELECT* FROM librarybook JOIN author ON author_book = id_author ";
	private static final String GETBOOK = "SELECT* FROM librarybook JOIN author ON author_book = id_author WHERE librarybook.id_book = ?";
	private static final String ADD_BOOK = "INSERT into library.librarybook(name_book,status_book,author_book)VALUES (?, ?,?) ";
	private static final String CHANGE_STATUS_BOOK = "UPDATE library.librarybook SET "
			+ "last_date_issue_book = ?, status_book=? , id_library_card_book =? " + "WHERE id_book=?";

	private static final String CHANGE_STATUS_BOOK_RETURN = "UPDATE library.librarybook SET "
			+ "last_date_issue_book = ?, status_book=?" + "WHERE id_book=?";
	private static final String DELAY_BOOK = "SELECT id,date_issue_book FROM readbook WHERE id_number_library_card = ?";

	private Author author;
	private Book book;

	@Override
	public boolean addEntity(Book entity) {
		openConnection();
		getPreparedStatement(ADD_BOOK);
		setString(1, entity.getBookName());
		setString(2, entity.getStatus());
		setInt(3, entity.getAuthor().getId());
		execute();
		return true;
	}

	@Override
	public boolean deleteEntity(Integer id) {
		throw new UnsupportedOperationException();

	}

	@Override
	public Book getEntityById(Integer id) {
		Book book = null;
		openConnection();
		getPreparedStatement(GETBOOK);
		setInt(1, id);
		executeQuery();
		if (resNext()) {
			book = buildBook(getResultSet());
			closeAll();
			return book;
		}
		closeAll();
		return book;
	}

	@Override
	public List<Book> getAll() {
		List<Book> listBook = new ArrayList<Book>();
		openConnection();
		getPreparedStatement(LIST_BOOK);
		executeQuery();
		while (resNext()) {
			listBook.add(buildBook(getResultSet()));
		}
		closeAll();
		return listBook;
	}

	@Override
	public Book update(Book entity) {
		openConnection();
		getPreparedStatement(CHANGE_STATUS_BOOK);
		setDate(1, entity.getDate());
		setString(2, entity.getStatus());
		setInt(3, entity.getIdPerson());
		setInt(4, entity.getId());
		execute();
		closeAll();
		return getEntityById(entity.getId());
	}

	@Override
	public Book updateAfterReturn(Book entity) {
		openConnection();
		getPreparedStatement(CHANGE_STATUS_BOOK_RETURN);
		setDate(1, entity.getDate());
		setString(2, entity.getStatus());
		setInt(3, entity.getIdPerson());
		execute();
		closeAll();
		return getEntityById(entity.getId());
	}

	private Book buildBook(ResultSet result) {
		book = new Book();
		book.setId(getInt("id_book"));
		book.setBookName(getString("name_book"));
		book.setStatus(getString("status_book"));
		book.setAuthor(buildAuthor(result));
		return book;
	}

	private Author buildAuthor(ResultSet result) {
		author = new Author();
		author.setId(getInt("id_author"));
		author.setName(getString("name_author"));
		author.setSurName(getString("surname_author"));
		author.setBirthDay(getDate("birthday_author"));
		return author;
	}

	@Override
	public List<Date> delayBook(Person person) {
		List<Date> dates = new ArrayList<>();
		openConnection();
		getPreparedStatement(DELAY_BOOK);
		setInt(1, person.getId());
		executeQuery();
		while (resNext()) {
			dates.add(getDate("date_issue_book"));
		}
		return dates;
	}
}
