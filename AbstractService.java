package com.kisanlink.service.core;

/**
 * @author Silxo
 *
 */

import java.util.List;

import com.kisanlink.exception.ServiceException;
import com.kisanlink.filter.SearchRequest;


public interface AbstractService<T> {	

	void save(T bean) throws ServiceException;
	void save(List<T> beans) throws ServiceException;
	boolean update(T bean) throws ServiceException;
	long getCount() throws ServiceException;	
	public List<T> search(SearchRequest request);
	public long searchCount(SearchRequest request);
}