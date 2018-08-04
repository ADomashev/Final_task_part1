package dao.daoimpl.collectiondao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import dao.daoimpl.dtbdao.abstractdao.DaoAbstractCollection;
import dao.interfacedao.IBookDao;
import entity.Book;
import entity.Person;

public class BookCollectionDao extends DaoAbstractCollection implements IBookDao {

	@Override
	public boolean addEntity(Book entity) {
		listBook.add(entity);
		return true;
	}

	@Override
	public boolean deleteEntity(Integer id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Book getEntityById(Integer id) {
		Book bookTmp = null;
		for (Book book : listBook) {
			if (book.getId() == id) {
				bookTmp = book;
			}
		}
		return bookTmp;
	}

	@Override
	public List<Book> getAll() {
		return listBook;
	}

	@Override
	public Book update(Book entity) {
		Book bookTmp = getEntityById(entity.getId());
		listBook.remove(bookTmp);
		addEntity(entity);
		return getEntityById(entity.getId());
	}

	@Override
	public List<Date> delayBook(Person person) {
		List<Date> listDateTmp = new ArrayList<>();
		for (Book book : listBook) {
			listDateTmp.add(book.getDate());
		}
		return listDateTmp;
	}

	@Override
	public Book updateAfterReturn(Book entity) {
		return update(entity);
	}

}
