package com.queue.messaging.inmemoryqueue.persistence;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="message")
@Getter @Setter
public class Message implements Cloneable{

    @Id
    @GeneratedValue
    private Long id;
    private String sender;
    private String receiver;
    private String subject;
    private String body;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

}
