package dao.daoimpl.collectiondao;

import java.util.List;

import dao.daoimpl.dtbdao.abstractdao.DaoAbstractCollection;
import dao.interfacedao.IIssuedBookDao;
import entity.IssuedBook;

public class IssueBookCollectionDao extends DaoAbstractCollection implements IIssuedBookDao {

	@Override
	public boolean addEntity(IssuedBook entity) {
		listIssueBook.add(entity);
		return false;
	}

	@Override
	public boolean deleteEntity(Integer id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public IssuedBook getEntityById(Integer id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<IssuedBook> getAll() {
		return listIssueBook;
	}

	@Override
	public IssuedBook update(IssuedBook entity) {
		throw new UnsupportedOperationException();
	}
}
