package com.kisanlink.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubDetails {
	
	@JsonProperty("Id")
	private String id;
	@JsonProperty("PlanName")
	private String planName;
	@JsonProperty("PackageName")
	private String packageName;
	@JsonProperty("StartDate")
	private String startDate;
	@JsonProperty("EndDate")
	private String endDate;
	@JsonProperty("UserId")
	private String userId;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "SubDetails [id=" + id + ", planName=" + planName + ", packageName=" + packageName + ", startDate="
				+ startDate + ", endDate=" + endDate + ", userId=" + userId + "]";
	}	
}