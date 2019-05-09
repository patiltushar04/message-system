package com.queue.messaging.inmemoryqueue.service;

import com.queue.messaging.inmemoryqueue.model.MessageTemplate;
import com.queue.messaging.inmemoryqueue.persistence.Message;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Component
public class MessageRepositoryBO {

    @Autowired
    MessageRepository messageRepository;
    public void storeMessage(MessageTemplate messageTemplate){
        Message message=new Message();
        BeanUtils.copyProperties(messageTemplate, message);
        messageRepository.save(message);
    }

    public List<MessageTemplate> retrieveReceivedMessage(String receiverName){
       List<Message> messages= messageRepository.findByReceiver(receiverName);
       return copySourceToDest(messages);
    }

    public List<MessageTemplate> retrieveSentMessages(String senderName){
        List<Message> messages= messageRepository.findBySender(senderName);
        return copySourceToDest(messages);
    }

    public MessageTemplate retrieveMessageDetails(Long id){
        Message message=messageRepository.findById(id);
        MessageTemplate messageTemplate=new MessageTemplate();
        BeanUtils.copyProperties(message,messageTemplate);
        return messageTemplate;
    }


    public List<MessageTemplate> copySourceToDest(List<Message> messages){
        List<MessageTemplate> messageTemplate=new ArrayList<MessageTemplate>();
        messageTemplate=messages.stream().map(m->{
            MessageTemplate messageTemplate1=new MessageTemplate();
            BeanUtils.copyProperties(m,messageTemplate1);
            return messageTemplate1;
        }).collect(Collectors.toList());
        return messageTemplate;
    }
}
