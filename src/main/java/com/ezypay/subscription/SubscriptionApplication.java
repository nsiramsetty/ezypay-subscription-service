package com.ezypay.subscription;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.TimeZone;

@SpringBootApplication
public class SubscriptionApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(SubscriptionApplication.class);


	public static void main(String[] args) {

	    SpringApplication.run(SubscriptionApplication.class, args);
	}

	@PostConstruct
	void setUTCTimeZone(){
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	@Override
	public void run(String... args) {
		log.info("Application started with command-line arguments: {}.", Arrays.toString(args));
	}
}
