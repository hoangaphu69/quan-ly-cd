package dao;

import java.util.List;

public interface GenericDAO<E> {
	
	List<E> getAll();
	void delete(int id);
	boolean save(E e);
	boolean update(E e);
	E findOne(int id);
	
}
