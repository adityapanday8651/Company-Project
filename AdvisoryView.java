package com.kisanlink.view;

public class AdvisoryView {
	private String id;
	private int advisoryId;
	private String name;
	private String address;
	private String leadTime;
	private String areaCentre;
	private String trustable;
	private String contactPerson;
	private String contactNumber;
	private String pest;
	private String others;
	public String getId() {
		return id;
	}
	public int getAdvisoryId() {
		return advisoryId;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getLeadTime() {
		return leadTime;
	}
	public String getAreaCentre() {
		return areaCentre;
	}
	public String getTrustable() {
		return trustable;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public String getPest() {
		return pest;
	}
	public String getOthers() {
		return others;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setAdvisoryId(int advisoryId) {
		this.advisoryId = advisoryId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setLeadTime(String leadTime) {
		this.leadTime = leadTime;
	}
	public void setAreaCentre(String areaCentre) {
		this.areaCentre = areaCentre;
	}
	public void setTrustable(String trustable) {
		this.trustable = trustable;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public void setPest(String pest) {
		this.pest = pest;
	}
	public void setOthers(String others) {
		this.others = others;
	}
	@Override
	public String toString() {
		return "AdvisoryView [id=" + id + ", advisoryId=" + advisoryId + ", name=" + name + ", address=" + address
				+ ", leadTime=" + leadTime + ", areaCentre=" + areaCentre + ", trustable=" + trustable
				+ ", contactPerson=" + contactPerson + ", contactNumber=" + contactNumber + ", pest=" + pest
				+ ", others=" + others + "]";
	}
}
