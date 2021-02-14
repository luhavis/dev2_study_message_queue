package com.luhavis.rabbitmq.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    private final RabbitTemplate rabbitTemplate;

    public Runner(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i=0; i<10; i++) {
            System.out.println("Sending message...");

            CustomMessage message = new CustomMessage("Hello!", 1, true);
            rabbitTemplate.convertAndSend(message);
    //        rabbitTemplate.convertAndSend("Hello!");


            System.out.println("send finished");
        }
    }
}
