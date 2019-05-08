package com.queue.messaging.inmemoryqueue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class InmemoryQueueApplication {

	public static void main(String[] args) {
		SpringApplication.run(InmemoryQueueApplication.class, args);
	}

}
