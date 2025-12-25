package com.openai.openai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OpenAiChatController {

    private final ChatClient chatClient;

    public OpenAiChatController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }


    @GetMapping("/chat/openai" )
    public String chat(@RequestParam("prompt") String prompt) {
        return chatClient.prompt(prompt).call().content();
    }
}
