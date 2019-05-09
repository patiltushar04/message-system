package com.queue.messaging.inmemoryqueue.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Getter @Setter
public class MessageTemplate implements Serializable {


     private Long id;
     private String sender;
     private String receiver;
     private String subject;
     private String body;
     private Date createdOn;

    public MessageTemplate() {
    }

    public MessageTemplate(String sender, String receiver, String subject, String body) {
        this.sender = sender;
        this.receiver = receiver;
        this.subject = subject;
        this.body = body;
    }
}
