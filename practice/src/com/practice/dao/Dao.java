package com.practice.dao;

import java.util.List;

public interface Dao<T> {
	T findByProperty(String property,String name);
	List<T> findAll();
}
