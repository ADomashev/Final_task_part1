package dao.daoimpl.dtbdao;

import java.util.List;

import dao.daoimpl.dtbdao.abstractdao.DaoAbstractSQL;
import dao.interfacedao.IAuthorDao;
import entity.Author;

public class AuthorDTBDao extends DaoAbstractSQL implements IAuthorDao {

	private static final String ADD_AUTHOR = "INSERT INTO library.author (name_author, surname_author,birthday_author)VALUES(?,?,?)";
	private static final String FIND_AUTHOR = "SELECT* FROM author WHERE name_author=? AND surname_author=?";

	@Override
	public boolean addEntity(Author entity) {
		openConnection();
		getPreparedStatement(ADD_AUTHOR);
		setString(1, entity.getName());
		setString(2, entity.getSurName());
		setDate(3, entity.getDateBirthday());
		execute();
		return true;
	}

	@Override
	public boolean deleteEntity(Integer id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Author getEntityById(Integer id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Author> getAll() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Author update(Author entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean findAuthor(Author author) {
		String expected = author.getName() + " " + author.getSurName();
		String str = "";
		openConnection();
		getPreparedStatement(FIND_AUTHOR);
		setString(1, author.getName());
		setString(2, author.getSurName());
		executeQuery();
		if (resNext()) {
			author.setId(getInt("id_author"));
			str = getString("name_author") + " " + getString("surname_author");
		}
		closeAll();
		if (expected.equals(str)) {
			return true;
		} else {
			return false;
		}
	}

}
