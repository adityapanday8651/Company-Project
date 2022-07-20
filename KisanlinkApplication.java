package com.kisanlink.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication 
@EnableAutoConfiguration
@EnableScheduling
@EnableMongoRepositories({"com.kisanlink.mongo.repository"})
@ComponentScan({"com.kisanlink.service","com.kisanlink.mongo.repository","com.kisanlink", "com.kisanlink.ws", "com.kisanlink.jwt"})
public class KisanlinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(KisanlinkApplication.class, args);
	}
}