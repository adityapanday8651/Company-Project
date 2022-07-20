package com.kisanlink.mongo.manager;

import java.util.List;

import com.kisanlink.mongo.Advisory;
import com.kisanlink.service.core.AbstractService;

public interface AdvisoryManager extends AbstractService<Advisory>{
	List<Advisory> findAll();
	Advisory findByid(String id);

}
