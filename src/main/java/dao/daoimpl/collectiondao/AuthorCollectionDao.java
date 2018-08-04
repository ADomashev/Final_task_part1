package dao.daoimpl.collectiondao;

import java.util.List;

import dao.daoimpl.dtbdao.abstractdao.DaoAbstractCollection;
import dao.interfacedao.IAuthorDao;
import entity.Author;

public class AuthorCollectionDao extends DaoAbstractCollection implements IAuthorDao {

	@Override
	public boolean addEntity(Author entity) {
		return listAuthor.add(entity);
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
	public boolean findAuthor(Author entity) {
		for (Author author : listAuthor) {
			if (author.equals(entity)) {
				return true;
			}
		}
		return false;
	}
}
