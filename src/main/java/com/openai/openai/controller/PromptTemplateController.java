package com.openai.openai.controller;

import com.openai.openai.advisors.TokenUsageAuditAdvisors;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class PromptTemplateController {

    private final ChatClient chatClient;

    public PromptTemplateController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

//    String promptTemplate = """
//            You are an expert email generator.
//            Write a professional email to "{customerName}" with the following message:
//            "{message}"
//
//            The email should be clear, concise, and polite.
//            Don't forget to include a proper greeting and closing.
//            Don't add Subject line.
//            """;

    @Value("classpath:promptTemplates/template.st")
    Resource promptTemplate;


    @GetMapping("/email" )
    public String email(@RequestParam("customerName") String customerName,
                        @RequestParam("message") String message) {
        return chatClient.prompt()
                .advisors(new TokenUsageAuditAdvisors())
                .system("You are an expert email generator.")
                .user(promptUserSpec
                        -> promptUserSpec.text(promptTemplate)
                        .param("customerName", customerName)
                        .param("message", message))
                .call().content();
    }

}
