package com.openai.openai.configuration;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ChatClientConfig {

    @Bean
    public ChatClient openAiChatClient(OpenAiChatModel openAiChatModel) {
        return ChatClient.create(openAiChatModel);
    }

//    @Primary
//    @Bean
//    public ChatClient ollamaChatClient(OllamaChatModel ollamaChatModel) {
//        ChatOptions chatOptions = ChatOptions.builder().model("gpt-4.1-mini")
//                .maxTokens(1000)
//                .temperature(0.8)
//                .build();
//        ChatClient.Builder chatClient =  ChatClient.builder(ollamaChatModel);
//        return chatClient
//                .defaultSystem("""
//                        You are on call support Engineer Your JOb is replying
//                        only on call queries related to tech work.
//                        """)
//                .defaultAdvisors(new SimpleLoggerAdvisor())
//                .defaultOptions(chatOptions)
//                .build();
//    }
}
