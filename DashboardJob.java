package com.kisanlink.jobs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.kisanlink.exception.ServiceException;
import com.kisanlink.filter.Search;
import com.kisanlink.filter.SearchRequest;
import com.kisanlink.logging.api.VCLogger;
import com.kisanlink.logging.api.impl.VCLogManager;
import com.kisanlink.mongo.Dashboard;
import com.kisanlink.mongo.Orders;
import com.kisanlink.mongo.manager.CollaboratorManager;
import com.kisanlink.mongo.manager.DashboardManager;
import com.kisanlink.mongo.manager.FarmersManager;
import com.kisanlink.mongo.manager.FranchiseManager;
import com.kisanlink.mongo.manager.NodalCentresManager;
import com.kisanlink.mongo.manager.OrdersManager;
import com.kisanlink.mongo.manager.UserManager;
import com.kisanlink.util.APIEndpoints;

@Component
public class DashboardJob {

	@Autowired DashboardManager dashboardManager;
	//@Autowired UserManager userManager;
	@Autowired CollaboratorManager collaboratorManager;
	@Autowired FarmersManager farmersManager;
	@Autowired OrdersManager ordersManager;
	@Autowired FranchiseManager franchiseManager;
	@Autowired NodalCentresManager nodalCentresManager;

	private static VCLogger logger = VCLogManager.getLogger(DashboardJob.class);
	String mehodName = null;
	String apiUrl = "kisanlink"+APIEndpoints.BASE_API_URL_V1+"/dashboard";


	@Scheduled(fixedRate=60*1000)
	public void dashboard() throws ServiceException {

		//long count = userManager.getCount();
		long count = 0;
		long count1 =collaboratorManager.getCount();
		long count2 =farmersManager.getCount();
		long count3 =franchiseManager.getCount();
		long count4 =nodalCentresManager.getCount();

		Dashboard dash = dashboardManager.findOne();

		if(dash == null) {
			dash = new Dashboard();
		}

		dash.setKisanSathis(count);
		dash.setCollaborators(count1);
		dash.setFarmers(count2);
		dash.setFranchiseCentres(count3);
		dash.setNodalCentres(count4);

		//for current orders
		SearchRequest request = new SearchRequest();
		request.setCurrentPage(0);
		request.setPageSize(100);
		request.setSort("ASC");
		request.setSortBy("createdAt");

		List<Search> list = new ArrayList<>();
		Search src = new Search();
		src.setKey("orderStage");
		src.setValue("Pending");
		src.setOperation("eq");
		list.add(src);
		request.setSearch(list);

		long orderCount = ordersManager.searchCount(request);
		dash.setCurrentOrders(orderCount);
		//for complete Orders
		SearchRequest request1 = new SearchRequest();
		request1.setCurrentPage(0);
		request1.setPageSize(100);
		request1.setSort("ASC");
		request1.setSortBy("createdAt");

		List<Search> list1 = new ArrayList<>();
		Search src1 = new Search();
		src1.setKey("orderStage");
		src1.setValue("Completed");
		src1.setOperation("eq");
		list1.add(src1);
		request1.setSearch(list1);

		long orderCount1 = ordersManager.searchCount(request1);
		dash.setCompletedOrders(orderCount1);

		//for Sales Values
		SearchRequest request2 = new SearchRequest();
		request2.setCurrentPage(0);
		request2.setPageSize(3);
		request2.setSort("ASC");
		request2.setSortBy("createdAt");
		request2.setSearch(null);

		//count/pagesize

		//		List<Orders> ordersList = ordersManager.search(request2);
		//		double value = 0.0;
		//		for(Orders orders : ordersList) {
		//			double sales=orders.getTotalAmount();
		//			value+=sales;
		//		}
		//		dash.setSalesValue(value);

		//count/pagesize by another way
		long count6 = ordersManager.getCount();
		long pages = (count6+request2.getPageSize()-1)/request2.getPageSize();
		double value = 0.0;
		for (int i = 0; i < pages; i++) {
			request2.setCurrentPage(i);
			List<Orders> data = ordersManager.search(request2);
			if(data!=null && !data.isEmpty()) {
				for(Orders orders : data) {
					double sales=orders.getTotalAmount();
					value+=sales;
				}
			}
		}
		dash.setSalesValue(value);

		dashboardManager.save(dash);
	}
}
