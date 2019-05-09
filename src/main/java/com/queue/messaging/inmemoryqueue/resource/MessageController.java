package com.queue.messaging.inmemoryqueue.resource;

import com.queue.messaging.inmemoryqueue.model.MessageTemplate;
import com.queue.messaging.inmemoryqueue.service.MessageRepositoryBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import javax.jms.Queue;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Queue messageSendReceiveQueue;

    @Autowired
    private MessageRepositoryBO messageRepositoryBO;

    public String responseMessage="Message sent successfully";
    @PostMapping("/send")
    public String messageReceiver(@RequestBody MessageTemplate messageTemplate){
        jmsTemplate.convertAndSend(messageSendReceiveQueue,messageTemplate);
        return responseMessage;
    }

    @GetMapping("/read/{receiverName}")
    public List<MessageTemplate> messageRead(@PathVariable String receiverName){
        return messageRepositoryBO.retrieveReceivedMessage(receiverName);
    }

    @GetMapping("/sent/{senderName}")
    public List<MessageTemplate> messagesSent(@PathVariable String senderName){
        return messageRepositoryBO.retrieveSentMessages(senderName);
    }

    @GetMapping("/details/{id}")
    public MessageTemplate messageDetails(@PathVariable Long id){
        return messageRepositoryBO.retrieveMessageDetails(id);
    }
}
