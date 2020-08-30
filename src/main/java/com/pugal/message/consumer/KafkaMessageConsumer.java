package com.pugal.message.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.pugal.config.ChannelConfigInterface;

import reactor.core.publisher.Flux;

@Component
public class KafkaMessageConsumer {
	
	
	
	
	//@StreamListener(ChannelConfigInterface.CHANNEL_NAME_FOR_RETRIEVAL)
	public void consumeMsgFromKafka(@Payload String msg ){
		
		sendMsgToResponse(msg);
		
		
		
	}
	
public Flux sendMsgToResponse(String msg ){
		
		System.out.println("Message from Kafka : "+ msg);
		return Flux.create( sink -> {
			Flux.just( msg).subscribe(data -> sink.next(data));
			});
		
		
		
	}

}
