package com.kisanlink.utilities;

public enum ConfigurationConstants {

	USER_SUBSCRIPTION_URL("user_subscription_url"),
	USER_LISTENING_MIN_URL("user_listening_minutes_url"),
	SF_CONSUMER_KEY("sf_consumer_key"),
	SF_CONSUMER_SECRET("sf_consumer_secret"),
	SF_USERNAME("sf_username"),
	SF_PASSWORD("sf_password"),
	SF_URL("sf_url"),
	SF_USER_URL("sf_user_url"),
	TUNE_GLOBAL_ACCESS_KEY("tune_global_access_key"),
	TUBE_GLOBAL_SECRET_KEY("tune_global_secret_key"),
	REVENUE_CAT_S3_LOCATION("revenue_cat_s3_location"),
	REHEGOO_ACCESS_KEY("rehegoo_access_key"),
	REHEGOO_SECRET_KEY("rehegoo_secret_key"), 
	REHEGOO_EMAIL("rehegoo_email");
	

	private final String value;

	private ConfigurationConstants(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
	}
}