package com.example.springwebserver;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Component;

@Component
public class Joker {

    private ChatClient.Builder chatClientBuilder;

    public Joker(ChatClient.Builder chatClientBuilder) {
        this.chatClientBuilder = chatClientBuilder;
    }

    public String joke(String city, String country) {
        return chatClientBuilder.build()
            .prompt(String.format("Tell me a nice joke for the city %s, %s. Output only the joke and nothing else.", city, country))
            .call()
            .content();
    }
}
