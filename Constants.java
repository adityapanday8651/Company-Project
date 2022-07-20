package com.kisanlink.utilities;

public enum Constants {

	SYSTEM("SYSTEM"),
	BAD_REQUEST("Bad request"),
	MANDATORY_FIELDS("Mandatory fields are missing"),
	USER_EXISTS("User already exists"),
	USER_EMAIL_EXISTS("User email already exists"),
	NO_USER_EXISTS("No user exists"),
	STORE_NOT_FOUND("Store not found"),
	USER_UPDATED("User updated successfully"),
	USER_DELETED("User deleted successfully"),
	PASSWORD("password"),
	USERNAME("username"),
	USERID("userId"),
	USER_ADDED("User added successfully"),
	PAYMENT_ADD("Payment added successfully"),
	PAYMENT_UPDATE("Payment updated successfully"),
	USER_SUBSCRIPTION_ERROR("Bad request, App user id missing"),
	LOGIN_SUCESS("Login success"),
	INVALID_CREDENTIALS("Invalid username or password"),
	MSISDN("msisdn"),
	REHEGOOID("rehegooId"),
	CLIENT_ID("client_id"),
	CLIENT_SECRET("client_secret"),
	GRANT_TYPE("grant_type"),
	SERVER_FILE_PATH("SERVER_FILE_PATH"),
	ID("id"),
	REHEGOO_EMAIL("rehegoo_email"), 
	AMAZON_S3_ACCESS_KEY("amazonS3AccessKey"),
	AMAZON_S3_SECRET_KEY("amazonS3SecretKey"),
	AMAZON_S3_BUCKET_NAME("amazonS3BucketName"),
	AMAZON_S3_ENDPOINT_URL("amazonS3EndPointUrl");
	
	private final String value;

	private Constants(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
	}

}