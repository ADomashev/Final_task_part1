package dao.interfacedao;

import entity.Author;

public interface IAuthorDao extends GeneralInterfaceDao<Author, Integer> {
	
	boolean findAuthor(Author author);
}
