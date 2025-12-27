package com.openai.openai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OllamaChatController {

//    private final ChatClient chatClient;
//
//    public OllamaChatController(ChatClient.Builder chatClientBuilder) {
//        this.chatClient = chatClientBuilder.build();
//    }
//
//
//    @GetMapping("/chat/ollama" )
//    public String chat(@RequestParam("prompt") String prompt) {
//        return chatClient.prompt(prompt).call().content();
//    }

}
