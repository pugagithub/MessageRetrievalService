package com.pugal.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;


public interface ChannelConfigInterface {
	

	    String CHANNEL_NAME_FOR_POSTING = "CHANNEL_NAME_FOR_POSTING";
	    String CHANNEL_NAME_FOR_RETRIEVAL = "CHANNEL_NAME_FOR_RETRIEVAL";

	    

	    @Output(CHANNEL_NAME_FOR_POSTING)
	    MessageChannel messagePostingChannel();
	    
	    @Input(CHANNEL_NAME_FOR_RETRIEVAL)
	    SubscribableChannel messageRetrievalChannel();

}
