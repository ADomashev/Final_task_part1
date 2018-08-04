package dao.daoimpl.dtbdao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.daoimpl.dtbdao.abstractdao.DaoAbstractSQL;
import dao.interfacedao.IIssuedBookDao;

import entity.IssuedBook;

public class IssuedBookDTBDao extends DaoAbstractSQL implements IIssuedBookDao {

	private static final String TAKE_BOOK = "INSERT INTO library.readbook(Id_read_book, id_number_library_card,date_issue_book,time_return_book)"
			+ "VALUES(?,?,?,?)";

	private static final String GET_LIST_ISSUE_BOOK = "SELECT* FROM readbook";
	private static final String SET_RETURN_TIME = "UPDATE library.readbook SET " + "time_return_book =? WHERE id=?";
	private static final String GET_ISSUE_BOOK_BY_ID = "SELECT* FROM readbook WHERE id=?";

	@Override
	public boolean addEntity(IssuedBook entity) {
		openConnection();
		getPreparedStatement(TAKE_BOOK);
		setInt(1, entity.getBookId());
		setInt(2, entity.getPersonId());
		setDate(3, entity.getDate());
		setString(4, entity.getReturnTime());
		execute();
		return true;
	}

	@Override
	public boolean deleteEntity(Integer id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public IssuedBook getEntityById(Integer id) {
		IssuedBook issuedBook = null;
		openConnection();
		getPreparedStatement(GET_ISSUE_BOOK_BY_ID);
		setInt(1, id);
		executeQuery();
		if (resNext()) {
			issuedBook = buildIssuedBook(getResultSet());
			closeAll();
			return issuedBook;
		}
		closeAll();
		return issuedBook;
	}

	@Override
	public List<IssuedBook> getAll() {
		List<IssuedBook> listBook = new ArrayList<IssuedBook>();
		openConnection();
		getPreparedStatement(GET_LIST_ISSUE_BOOK);
		executeQuery();
		while (resNext()) {
			listBook.add(buildIssuedBook(getResultSet()));
		}
		closeAll();
		return listBook;
	}

	@Override
	public IssuedBook update(IssuedBook entity) {
		openConnection();
		getPreparedStatement(SET_RETURN_TIME);
		setString(1, entity.getReturnTime());
		setInt(2, entity.getId());
		execute();
		closeAll();
		return getEntityById(entity.getId());
	}

	private IssuedBook buildIssuedBook(ResultSet resultSet) {
		IssuedBook issuedBook = new IssuedBook();
		issuedBook.setId(getInt("id"));
		issuedBook.setBookId(getInt("Id_read_book"));
		issuedBook.setPersonId(getInt("id_number_library_card"));
		issuedBook.setDate(getDate("date_issue_book"));
		issuedBook.setReturnTime(getString("time_return_book"));
		return issuedBook;
	}

}
