package dao.daoimpl.collectiondao;

import java.util.List;

import dao.daoimpl.dtbdao.abstractdao.DaoAbstractCollection;
import dao.interfacedao.IPersanDao;
import entity.Person;

public class PersonCollectionDao extends DaoAbstractCollection implements IPersanDao {

	@Override
	public boolean addEntity(Person entity) {
		listPerson.add(entity);
		return false;
	}

	@Override
	public boolean deleteEntity(Integer id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Person getEntityById(Integer id) {
		Person personTmp = null;
		for (Person person : listPerson) {
			if (person.getId() == id) {
				personTmp = person;
			}
		}
		return personTmp;
	}

	@Override
	public List<Person> getAll() {
		return listPerson;
	}

	@Override
	public Person update(Person entity) {
		Person personTmp = getEntityById(entity.getId());
		listBook.remove(personTmp);
		addEntity(entity);

		return getEntityById(entity.getId());
	}

	@Override
	public boolean loginExist(String login) {
		for (Person person : listPerson) {
			if (person.getLogin().equals(login)) {
				return true;
			} else
				return false;
		}
		return false;
	}
}
