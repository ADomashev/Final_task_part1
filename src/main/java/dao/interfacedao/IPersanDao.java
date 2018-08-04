package dao.interfacedao;

import entity.Person;

public interface IPersanDao extends GeneralInterfaceDao<Person, Integer> {

	public boolean loginExist(String login);
}
