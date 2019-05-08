package com.queue.messaging.inmemoryqueue.service;

import com.queue.messaging.inmemoryqueue.model.MessageTemplate;
import com.queue.messaging.inmemoryqueue.persistence.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface MessageRepository extends CrudRepository<Message,String> {

    public List<Message> findByReceiver(String receiver);
    public List<Message> findBySender(String receiver);
}
