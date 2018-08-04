package dao.daoimpl.dtbdao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.daoimpl.dtbdao.abstractdao.DaoAbstractSQL;
import dao.interfacedao.IPersanDao;
import entity.Person;

public class PersonDTBDao extends DaoAbstractSQL implements IPersanDao {

	private static final String ADD_LIBRARY_CARD = "INSERT INTO library.librarycard "
			+ "(owner_name,owner_surname,owner_phone_number,login, password, accessLevel)" + "VALUES(?,?,?,?,?,?)";
	private static final String GET_LIST_PERSON = "Select* from librarycard";

	private static final String IS_PASS_EXIST = "SELECT login FROM librarycard where login =?";

	private static final String UPDATE_PERSON = "UPDATE librarycard SET owner_name=?, owner_surname=?,owner_phone_number=?,"
			+ "number_issued_book=?,number_read_book=?,login=?,password=?,accessLevel=? WHERE id_librarycard=?";

	@Override
	public boolean addEntity(Person entity) {
		boolean flag = loginExist(entity.getLogin());
		if (!flag) {
			openConnection();
			getPreparedStatement(ADD_LIBRARY_CARD);
			setString(1, entity.getName());
			setString(2, entity.getSurname());
			setInt(3, entity.getPhoneNumber());
			setString(4, entity.getLogin());
			setString(5, entity.getPassword());
			setInt(6, entity.getAccessLevel());
			execute();
			closeAll();
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteEntity(Integer id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Person getEntityById(Integer id) {
		throw new UnsupportedOperationException();
	}

	public List<Person> getAll() {
		List<Person> list = new ArrayList<>();
		openConnection();
		getPreparedStatement(GET_LIST_PERSON);
		executeQuery();
		while (resNext()) {
			list.add(buildPerson(getResultSet()));
		}
		closeAll();
		return list;

	}

	@Override
	public Person update(Person entity) {
		openConnection();
		getPreparedStatement(UPDATE_PERSON);
		setString(1, entity.getName());
		setString(2, entity.getSurname());
		setInt(3, entity.getPhoneNumber());
		setInt(4, entity.getNumberIssuedBook());
		setInt(5, entity.getNumberReadBook());
		setString(6, entity.getLogin());
		setString(7, entity.getPassword());
		setInt(8, entity.getAccessLevel());
		setInt(9, entity.getId());
		execute();
		closeAll();
		return null;
	}

	private Person buildPerson(ResultSet resultSet) {
		Person person = null;
		person = new Person();
		person.setName(getString("owner_name"));
		person.setSurname(getString("owner_surname"));
		person.setId(getInt("id_librarycard"));
		person.setLogin(getString("login"));
		person.setAccessLevel(getInt("accessLevel"));
		person.setPassword(getString("password"));
		person.setPhoneNumber(getInt("owner_phone_number"));
		person.setNumberIssuedBook(getInt("number_issued_book"));
		return person;

	}

	@Override
	public boolean loginExist(String login) {
		String expectedLogin = login;
		String logTmp = "";
		openConnection();
		getPreparedStatement(IS_PASS_EXIST);
		setString(1, login);
		executeQuery();
		if (resNext()) {
			logTmp = getString("login");
			closeAll();
		}
		if (expectedLogin.equals(logTmp)) {
			return true;
		} else {
			closeAll();
			return false;
		}
	}
}
