package run;


import java.util.Arrays;

import entity.Author;
import entity.Book;

import entity.Person;
import menu.DistributionMenu;


public class Runner {

	public static void main(String[] args) {

		DistributionMenu menu = new DistributionMenu();
		menu.showMenu();
	

	}
	public static void parseToDate(String date) {
		String[]arrTmp = date.split("\\.|\\s|,|\\\\|:|;");
		System.out.println(Arrays.toString(arrTmp));
		int year = Integer.valueOf(arrTmp[0]);
		int month = Integer.valueOf(arrTmp[1]);
		int day = Integer.valueOf(arrTmp[2]);
		System.out.println(year +" "+month+" "+day);
	}
	

	public static Person buildPerson() {
		Person person = new Person();
		
		person.setName("Alex");
		person.setSurname("Domashevski");
		person.setPhoneNumber(1312903);
		person.setLogin("alex3");
		person.setAccessLevel(2);
		person.setPassword("fk3hbf3");
		return person;
	}
	
	public static Book buildBook() {
		Book book = new Book();
		book.setBookName("ffff");
		book.setStatus("not issued");
		book.setAuthor(buildAuthor());
		return book;
		
	}
	
	public static Author buildAuthor() {
		Author author = new Author();
		 author.setName("fff");
		 author.setSurName("ffff");
		 author.setBirthDay(1868,06,28);
//		 System.out.println(author);
		 return author;
	}
	
}
