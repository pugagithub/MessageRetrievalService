package com.pugal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pugal.config.ChannelConfigInterface;
import com.pugal.message.producer.KafkaMessageProducer;

import reactor.core.publisher.Mono;

@RestController
@EnableBinding(ChannelConfigInterface.class)
@RequestMapping("/message")
public class MessagePostingController {
	
	@Autowired
	private KafkaMessageProducer producer;
	
	@GetMapping(value = "" ) 
	Mono<String> postMessage(@RequestParam("message") String msg){
		
		producer.sendMsgToKafka(msg);
		//Store it in kafka topic
		return Mono.just("Hiiii");
	}

}
