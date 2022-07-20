package com.kisanlink.mongo.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kisanlink.exception.ServiceException;
import com.kisanlink.filter.SearchRequest;
import com.kisanlink.mongo.Advisory;
import com.kisanlink.mongo.manager.AdvisoryManager;
import com.kisanlink.mongo.repository.AdvisoryRepository;
import com.kisanlink.service.core.GenericSearchRepository;

@Service("AdvisoryManager")
public class AdvisoryManagerImpl implements AdvisoryManager{
	@Autowired AdvisoryRepository advisoryRepository;
	@Autowired GenericSearchRepository searchRepository;

	@Override
	public void save(Advisory bean) throws ServiceException {
		// TODO Auto-generated method stub
		advisoryRepository.save(bean);
	}

	@Override
	public void save(List<Advisory> beans) throws ServiceException {
		// TODO Auto-generated method stub
		advisoryRepository.saveAll(beans);
	}

	@Override
	public boolean update(Advisory bean) throws ServiceException {
		// TODO Auto-generated method stub
		advisoryRepository.save(bean);
		return true;
	}

	@Override
	public long getCount() throws ServiceException {
		// TODO Auto-generated method stub
		return advisoryRepository.count();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Advisory> search(SearchRequest request) {
		// TODO Auto-generated method stub
		return (List<Advisory>) searchRepository.search(request, Advisory.class);
	}

	@Override
	public List<Advisory> findAll() {
		// TODO Auto-generated method stub
		return advisoryRepository.findAll();
	}

	@Override
	public Advisory findByid(String id) {
 		return advisoryRepository.findByid(id);
	}

	@Override
	public long searchCount(SearchRequest request) {
		// TODO Auto-generated method stub
		return searchRepository.searchCount(request, Advisory.class);
	}

	 
}
