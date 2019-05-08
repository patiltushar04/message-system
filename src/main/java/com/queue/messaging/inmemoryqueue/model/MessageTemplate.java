package com.queue.messaging.inmemoryqueue.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class MessageTemplate implements Serializable {


     private String sender;
     private String receiver;
     private String subject;
     private String body;

    public MessageTemplate() {
    }

    public MessageTemplate(String sender, String receiver, String subject, String body) {
        this.sender = sender;
        this.receiver = receiver;
        this.subject = subject;
        this.body = body;
    }
}
