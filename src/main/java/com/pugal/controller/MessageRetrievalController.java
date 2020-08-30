package com.pugal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.http.MediaType;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pugal.config.ChannelConfigInterface;
import com.pugal.message.consumer.KafkaMessageConsumer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

@RestController
@EnableBinding(ChannelConfigInterface.class)
@RequestMapping("/message")
public class MessageRetrievalController {
	
	@Autowired
	private KafkaMessageConsumer consumer;
	
	private FluxSink<String> sink;
	Flux<String> flux = Flux.create( sink -> this.sink = sink );
	
	@StreamListener(ChannelConfigInterface.CHANNEL_NAME_FOR_RETRIEVAL)
	public void consume(@Payload String message) {
		System.out.println("Message From Kafka : "+ message);
		if(this.sink!=null)this.sink.next(message);
		else {
			System.out.println("SINK iS NULL");
		}
	}
	
	@GetMapping(value = "" , produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	Flux<String> getMessages(@RequestParam("profile-id") String profileId){
		System.out.println("Message from Kafka For Profile Id  : "+ profileId);
		return consumer.sendMsgToResponse(profileId);
	}
	
	@RequestMapping(value = "/getMessageFromKafka", method = RequestMethod.GET, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<String> getMessageString() {
		return flux.publish().autoConnect().cache(10).log();
	}
	
	
	

}
