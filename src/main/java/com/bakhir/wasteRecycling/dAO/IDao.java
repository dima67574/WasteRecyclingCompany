package com.bakhir.wasteRecycling.dAO;

public interface IDao<T> {
	void insert(T entity);

	T getById(long id);

	void update(T entity);

	void delete(T entity);

}
