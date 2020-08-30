package com.pugal.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;


public interface ChannelConfigInterface {
	

	    String CHANNEL_NAME_FOR_RETRIEVAL = "CHANNEL_NAME_FOR_RETRIEVAL";

	    @Input(CHANNEL_NAME_FOR_RETRIEVAL)
	    SubscribableChannel messageRetrievalChannel();

}
