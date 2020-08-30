package com.pugal.message.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;

import com.pugal.config.ChannelConfigInterface;

@Component
public class KafkaMessageProducer {
	
	@Autowired
	private ChannelConfigInterface channelConfig;
	
	public void sendMsgToKafka(String msg){
		
		Message<String> kafkaMsg = MessageBuilder
		        .withPayload(msg)
		        .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
		        .build();
				
				channelConfig.messagePostingChannel().send(kafkaMsg);
	}

}
