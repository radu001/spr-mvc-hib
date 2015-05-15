package com.sprhib.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, PK extends Serializable> {

	public int insert(T object);

	public T getByPK(int key);

	public void update(T object);

	public void delete(T object);

	public List<T> getAll();

	Long getCount();
}
