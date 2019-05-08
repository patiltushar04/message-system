package com.queue.messaging.inmemoryqueue.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;

@EnableJms
@Configuration
public class MessageQueue {
    @Bean
    public Queue messageSendReceiveQueue(){

        return new ActiveMQQueue("messageSendReceiveQueue");
    }
}
