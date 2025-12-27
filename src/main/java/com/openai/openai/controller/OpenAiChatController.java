package com.openai.openai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.ai.chat.memory.ChatMemory.CONVERSATION_ID;

@RestController
@RequestMapping("/api")
public class OpenAiChatController {

    private final ChatClient chatClient;

    public OpenAiChatController(@Qualifier("chatMemoryChatClient1") ChatClient chatClient) {
        this.chatClient = chatClient;
    }


    @GetMapping("/chat/memory/{username}" )
    public ResponseEntity<String> memory(@RequestParam("prompt") String prompt,
                                         @PathVariable("username") String username) {
        return ResponseEntity.ok(chatClient.prompt().user(prompt)
                        .advisors(advisorSpec -> advisorSpec.param(
                                CONVERSATION_ID, username)
                        )
                .call().content());

    }


}
