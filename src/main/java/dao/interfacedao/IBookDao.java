package dao.interfacedao;

import java.sql.Date;
import java.util.List;

import entity.Book;
import entity.Person;

public interface IBookDao extends GeneralInterfaceDao<Book, Integer> {

	List<Date> delayBook(Person person);

	Book updateAfterReturn(Book entity);

}
