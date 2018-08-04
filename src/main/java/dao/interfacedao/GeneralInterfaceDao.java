package dao.interfacedao;

import java.util.List;

import entity.GeneralEntity;

public interface GeneralInterfaceDao<E extends GeneralEntity, K> {
	boolean addEntity(E entity);

	boolean deleteEntity(K id);

	E getEntityById(K id);

	List<E> getAll();

	E update(E entity);
}
