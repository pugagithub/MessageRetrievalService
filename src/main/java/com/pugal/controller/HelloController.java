package com.pugal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class HelloController {
	@GetMapping("/hello")
		private Mono<String> sayHello() {
		    return Mono.just("Hello World!!!\""); 
		}
}

