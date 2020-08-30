package com.pugal;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
public class MessageRetrievalServiceApplication {

	public static void main(String[] args) {
		System.out.println("Hi Pugal Am From Message Retrieval Service");
		SpringApplication.run(MessageRetrievalServiceApplication.class, args);
	}

}
