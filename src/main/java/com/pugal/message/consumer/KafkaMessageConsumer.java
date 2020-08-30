package com.pugal.message.consumer;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.pugal.config.ChannelConfigInterface;

@Component
public class KafkaMessageConsumer {
	
	@StreamListener(ChannelConfigInterface.CHANNEL_NAME_FOR_RETRIEVAL)
	void consumeMsgFromKafka(@Payload String msg){
		
		System.out.println("Message from Kafka : "+ msg);
		
	}

}
