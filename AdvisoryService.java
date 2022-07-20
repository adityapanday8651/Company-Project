package com.kisanlink.ws;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kisanlink.filter.SearchRequest;
import com.kisanlink.logging.api.VCLogger;
import com.kisanlink.logging.api.impl.VCLogManager;
import com.kisanlink.model.message.Message;
import com.kisanlink.mongo.Advisory;
import com.kisanlink.mongo.AllIdConfiguration;
import com.kisanlink.mongo.manager.AdvisoryManager;
import com.kisanlink.mongo.manager.AllIdConfigurationManager;
import com.kisanlink.service.core.GenericSearchRepository;
import com.kisanlink.util.APIEndpoints;
import com.kisanlink.utilities.DateUtils;
import com.kisanlink.view.AdvisoryView;
import com.kisanlink.view.ListResponseView;
import com.kisanlink.view.ResponseView;

@RestController
@RequestMapping(path=APIEndpoints.BASE_API_URL_V1+"/advisory")
public class AdvisoryService extends GenericService{
	private static VCLogger logger = VCLogManager.getLogger(AdvisoryService.class);
	
	@Autowired AdvisoryManager advisoryManager;
	@Autowired GenericSearchRepository searchRepository;
	@Autowired AllIdConfigurationManager allIdConfigurationManager;
	
	String methodName=null;

	@PostMapping(value="/save", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveCarts(@RequestBody AdvisoryView view, HttpServletRequest request){
		logger.info("advisory save service call started - {0}", new Date());
		ResponseView res=new ResponseView();
		Advisory advisory = null;
		try {
			AllIdConfiguration config=	allIdConfigurationManager.findByName("advisory");
			advisory = advisoryManager.findByid(view.getId());
			if(advisory==null) {
				advisory = new Advisory();
				BeanUtils.copyProperties(view, advisory);
				DateUtils.setBaseData(advisory, "System");
				res.setMessage("Advisory added successfully");
				res.setStatus(true);
			}else{
				BeanUtils.copyProperties(view, advisory,"id");
				DateUtils.setModifiedBaseData(advisory, "System");
				res.setMessage("Advisory updated successfully");
			}
			
			if(config==null) {
				config=new AllIdConfiguration();
				config.setLastGeneratedId(200000);
				advisory.setAdvisoryId(config.getLastGeneratedId());
				DateUtils.setBaseData(config, "System");
			}else {
				advisory.setAdvisoryId(config.getLastGeneratedId()+1);
				config.setLastGeneratedId(config.getLastGeneratedId()+1);
				DateUtils.setModifiedBaseData(config, "System");
			}
			
			allIdConfigurationManager.save(config);
			res.setStatus(true);
			advisoryManager.save(advisory);
		}catch(Exception e) {
			logger.error("Exception while advisory save info - {0}", e, e.getMessage());
			res.setMessage("Saving Advisory Failed");
			res.setStatus(false);
			return toError400(res);
		}
		res.setStatus(true);
		logger.info("advisory save service call completed - {0}", new Date());
		return toSuccess(res);
	}
	
	

	@PostMapping(value="/list",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> searchAdvisory(@RequestBody SearchRequest searchRequest){
		List<AdvisoryView> views = new ArrayList<>();
		List<Advisory> list = advisoryManager.search(searchRequest);
		for(Advisory advisory : list) {
			AdvisoryView view = new AdvisoryView();
			BeanUtils.copyProperties(advisory, view);
			views.add(view);
		}
		return toSucess(new ListResponseView(list.size(),list));	
	}	
}
