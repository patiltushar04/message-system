package com.queue.messaging.inmemoryqueue;

import com.queue.messaging.inmemoryqueue.model.MessageTemplate;
import com.queue.messaging.inmemoryqueue.resource.MessageController;
import com.queue.messaging.inmemoryqueue.service.MessageRepositoryBO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import javax.jms.Queue;
import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MessageController.class)
public class RestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    MessageRepositoryBO messageRepositoryBO;

    @MockBean
    JmsTemplate jmsTemplate;

    @MockBean
    Queue messageSendReceiveQueue;

    @Test
    public void givenMessage_whenStored_thenReturnSuccessMessage() throws Exception{
        MessageTemplate messageTemplate=new MessageTemplate("Tushar","Patil","Hello","Hi There");
        //TODO mock jmstemplate call
       // doNothing().when(jmsTemplate.convertAndSend(messageSendReceiveQueue,messageTemplate)
        MvcResult result =mockMvc.perform(post("/message/send")
            .content("{ \"sender\":\"Tushar\", \"receiver\": \"Patil\", \"subject\": \"Hi There\", \"body\": \"Looking forward to work with you\" }")).andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }


    @Test
    public void givenSender_whenMessage_thenReturnMessage() throws Exception{
        MessageTemplate messageTemplate=new MessageTemplate("Tushar","Patil","Hello","Hi There");
        List<MessageTemplate> messageList= Arrays.asList(messageTemplate);
        given(messageRepositoryBO.retrieveReceivedMessage("Patil")).willReturn(messageList);
        mockMvc.perform(get("/message/read/Patil").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
