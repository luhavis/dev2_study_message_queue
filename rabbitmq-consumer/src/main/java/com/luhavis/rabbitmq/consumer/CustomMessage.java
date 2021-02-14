package com.luhavis.rabbitmq.consumer;

import lombok.Getter;
import lombok.Setter;

public class CustomMessage {

    @Getter @Setter
    private String text;

    @Getter @Setter
    private int priority;

    @Getter @Setter
    private boolean secret;

    protected CustomMessage() {

    }

    public CustomMessage(String text, int priority, boolean secret) {
        this.text = text;
        this.priority = priority;
        this.secret = secret;
    }
}