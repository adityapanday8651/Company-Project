package com.kisanlink.service.core;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kisanlink.filter.Lookup;
import com.kisanlink.filter.SearchRequest;
import com.mongodb.client.result.UpdateResult;
@Repository
public interface GenericSearchRepository {

	public List<?> search(SearchRequest request,String key, String value,Class<?> clazz); 
	public long searchCount(SearchRequest request,String key, String value,Class<?> clazz);
	
	public List<?> search(SearchRequest request,Class<?> clazz); 
	public long searchCount(SearchRequest request,Class<?> clazz);
	
	public List<?> searchIn(SearchRequest request,String key, List<String> value,Class<?> clazz); 
	public long searchCountIn(SearchRequest request,String key, List<String> value,Class<?> clazz);
	
	public List<?> in(List<String> ids,String key,Class<?> clazz); 
	
	public List<?> lookup(Lookup lookup);
	
	public UpdateResult update(String searchKey,List<String> searchValue,String replaceKey, String replaceValue, Class<?> clazz) ;
}
