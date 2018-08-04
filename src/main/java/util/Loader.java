package util;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entity.Author;
import entity.Book;
import entity.IssuedBook;
import entity.Person;

public class Loader {
	private static int bookId = 0;
	public List<Book> getListBook(){
		List<Book> books= new ArrayList<Book>();
		
		Book book1 = new Book(1,"Eugene Onegin","not issued",new Date(setTime(2018, 12, 15)),1,new Author(1,"Aleksander","Pushkin",setCalendar(1799,6,6)));
		Book book2 = new Book(2,"The Idiot","not issued",new Date(setTime(2018, 12, 15)),null,new Author(2,"Fyodor","Dostoyevsky",setCalendar(1821,10,11)));
		Book book3 = new Book(3,"Anna Karenina","not issued",new Date(setTime(2018, 12, 15)),null,new Author(3,"Lev","Tolstoy",setCalendar(1828,9,9)));
		Book book4 = new Book(4,"Selected Stories","not issued",new Date(setTime(2018, 12, 15)),null,new Author(4,"Anton","Chekhov",setCalendar(1860,1,15)));
		Book book5 = new Book(5,"The Karamazov Brothers","not issued",new Date(setTime(2018, 12, 15)),null,new Author(2,"Fyodor","Dostoyevsky",setCalendar(1821,10,11)));
		Book book6 = new Book(6,"Master and Margarita","not issued",new Date(setTime(2018, 12, 15)),null,new Author(5,"Mihail","Bulgakov",setCalendar(1891,5,15)));
		
		
		Book book7 = new Book(7,"Anna Karenina","not issued",new Date(setTime(2018, 12, 15)),null,new Author(3,"Lev","Tolstoy",setCalendar(1828,9,9)));
		Book book8 = new Book(8,"Eugene Onegin","not issued",new Date(setTime(2018, 12, 15)),null,new Author(1,"Aleksander","Pushkin",setCalendar(1799,6,6)));
		Book book9 = new Book(8,"The Idiot","not issued",new Date(setTime(2018, 12, 15)),null,new Author(2,"Fyodor","Dostoyevsky",setCalendar(1821,10,11)));
		Book book10 = new Book(10,"Master and Margarita","not issued",new Date(setTime(2018, 12, 15)),null,new Author(5,"Mihail","Bulgakov",setCalendar(1891,5,15)));
		
		books.add(book1);
		books.add(book2);
		books.add(book3);
		books.add(book4);
		books.add(book5);
		books.add(book6);
		books.add(book7);
		books.add(book8);
		books.add(book9);
		books.add(book10);
		
		for (Book book : books) {
			book.setId(++bookId);
		}
		
		return books;
	}
	
	public List<Author> getListAuthor(){
		List<Author> listAuthor = new ArrayList<>();
		
		Author author1 = new Author(1,"Aleksander","Pushkin",setCalendar(1799,6,6));
		Author author2 = new Author(2,"Fyodor","Dostoyevsky",setCalendar(1821,10,11));
		Author author3 = new Author(3,"Lev","Tolstoy",setCalendar(1828,9,9));
		Author author4 = new Author(4,"Anton","Chekhov",setCalendar(1860,1,15));
		Author author5 = new Author(5,"Mihail","Bulgakov",setCalendar(1891,5,15));
		
		listAuthor.add(author1);
		listAuthor.add(author2);
		listAuthor.add(author3);
		listAuthor.add(author4);
		listAuthor.add(author5);
		
		return listAuthor;
	}
	
	public List<Person> getListPerson(){
		List<Person> persons= new ArrayList<Person>();
		Person person1 = new Person(1,"Alex", "Domashevski", "alex", "fk3hbf3", 2, 1312903, 0);
		Person person2 = new Person(2, "Alex1","Petrov", "alex1","fk3hbf3",1,1522356,0);
		Person person3 = new Person(3, "Nikola", "Glushkov", "alex2", "fk3hbf3", 1, 1234567, 0);
		
		persons.add(person1);
		persons.add(person2);
		persons.add(person3);
		
		return persons;
	}
	
	public List<IssuedBook> getListIssueBook(){
		List<IssuedBook> listIssueBook = new ArrayList<IssuedBook>();
		
		//IssuedBook iss1= new IssuedBook(bookId, personId, date)
		return listIssueBook;
	}
	
	
	
	public static long setTime(int year, int month, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, day);
		Date date = new Date(calendar.getTimeInMillis());
		return date.getTime();
	
	}
	public static Calendar setCalendar(int year, int month, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, day);
		return calendar;
	}
	
	
	
}
