package com.luhavis.rabbitmq.consumer.service;

import com.luhavis.rabbitmq.consumer.CustomMessage;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class CustomMessageListener {

    /**
     * test 큐 안에 있는 메세지를 가져온다
     * */
    @RabbitListener(queues = "test3")
    public void receiveMessage(final Message message) {
        System.out.println("receive message ...");

        System.out.println(new String(message.getBody()));
    }
}
