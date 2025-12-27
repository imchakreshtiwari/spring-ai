package com.openai.openai.configuration;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.client.advisor.api.Advisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ChatMemoryChatClient {


    @Bean("chatMemoryChatClient1")
    public ChatClient chatClient(ChatClient.Builder chatClientbuilder, ChatMemory chatMemory) {

        Advisor loggerAdvisor = new SimpleLoggerAdvisor();

        Advisor memoryChatAdvisor =
                MessageChatMemoryAdvisor.builder(chatMemory).build();
        return chatClientbuilder
                .defaultAdvisors(List.of(memoryChatAdvisor, loggerAdvisor))
                .build();
    }
}
