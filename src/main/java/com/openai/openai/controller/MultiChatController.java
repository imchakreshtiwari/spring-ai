package com.openai.openai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MultiChatController {

    private final ChatClient openAiChatClient;

    public MultiChatController(@Qualifier("openAiChatClient") ChatClient openAiChatClient) {
        this.openAiChatClient = openAiChatClient;
    }

    @GetMapping("/chat/openai" )
    public String chatOpenAi(@RequestParam("prompt") String prompt) {
        return openAiChatClient.prompt()
                .system("""
                        You are a HR assitant which will only respondabut HR related query
                        """)
                .call()
                .content();
    }
}
