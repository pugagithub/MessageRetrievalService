package com.pugal;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class MessageRetrievalServiceApplication {

	public static void main(String[] args) {
		System.out.println("Hi Pugal Am From Message Retrieval Service");
		SpringApplication.run(MessageRetrievalServiceApplication.class, args);
	}
	
	
	@Bean(name = "ResponseFlux")
	Flux getResponseFlux() {
		
		return Flux.just("");
		
	}

}
