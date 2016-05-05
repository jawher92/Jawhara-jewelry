package com.jawhara.dao;

import java.io.Serializable;
import java.util.List;

public interface DaoInterface <T, Id extends Serializable>{
	public void persist(T entity); //ajout
	public void update(T entity);
	public T findById(Id id);
	public List<T> findAll();
	public void deleteAll();
	public int delete(int id);
}
