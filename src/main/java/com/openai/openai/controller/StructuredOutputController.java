package com.openai.openai.controller;

import com.openai.openai.model.CountryCity;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class StructuredOutputController {

    private final ChatClient chatClient;

    public StructuredOutputController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }


    @GetMapping("/res")
    public ResponseEntity<CountryCity> stream(@RequestParam("prompt") String prompt) {
        CountryCity countryCity = chatClient.prompt(prompt).call().entity(CountryCity.class);
        return ResponseEntity.ok(countryCity);
    }
}
