package com.queue.messaging.inmemoryqueue.resource;

import com.queue.messaging.inmemoryqueue.model.MessageTemplate;
import com.queue.messaging.inmemoryqueue.service.MessageRepositoryBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @Autowired
    MessageRepositoryBO messageRepositoryBO;

    @JmsListener(destination = "messageSendReceiveQueue")
    public void messageListener(MessageTemplate messageTemplate ){
        messageRepositoryBO.storeMessage(messageTemplate);
    }
}

