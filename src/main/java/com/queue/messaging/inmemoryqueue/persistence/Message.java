package com.queue.messaging.inmemoryqueue.persistence;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

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
    @CreationTimestamp
    private Date createdOn;
}
