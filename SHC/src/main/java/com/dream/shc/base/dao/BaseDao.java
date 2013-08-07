package com.dream.shc.base.dao;
import java.util.List;

import com.mongodb.WriteResult;

public interface BaseDao<T> {
	/**
	 * save object
	 * 2013-7-29
	 * void
	 */
	public void save(T object);
    /**
     * find object by id
     * 2013-7-29
     * T
     */
	public T get(String id);
    /**
     * delete object by id
     * 2013-7-29
     * void
     */
	public void delete(String id);
	/**
	 * create collection
	 * 2013-7-29
	 * void
	 */
	public void createCollection();
	/**
	 * drop collection
	 * 2013-7-29
	 * void
	 */
	public void dropCollection();

}
