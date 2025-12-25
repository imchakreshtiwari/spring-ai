package com.openai.openai.advisors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClientRequest;
import org.springframework.ai.chat.client.ChatClientResponse;
import org.springframework.ai.chat.client.advisor.api.CallAdvisor;
import org.springframework.ai.chat.client.advisor.api.CallAdvisorChain;
import org.springframework.ai.chat.client.advisor.api.StreamAdvisor;
import org.springframework.ai.chat.client.advisor.api.StreamAdvisorChain;
import org.springframework.ai.chat.metadata.Usage;
import org.springframework.ai.chat.model.ChatResponse;
import reactor.core.publisher.Flux;

public class TokenUsageAuditAdvisors implements CallAdvisor, StreamAdvisor {

    private static final Logger logger = LoggerFactory.getLogger(TokenUsageAuditAdvisors.class);
    @Override
    public ChatClientResponse adviseCall(ChatClientRequest chatClientRequest, CallAdvisorChain callAdvisorChain) {
        ChatClientResponse chatClientResponse = callAdvisorChain.nextCall(chatClientRequest);
        ChatResponse chatResponse = chatClientResponse.chatResponse();
        Usage usage = chatResponse.getMetadata().getUsage();
        int promptTokens = usage.getPromptTokens();
        int completionTokens = usage.getCompletionTokens();
        int totalTokens = usage.getTotalTokens();
        logger.info("Token Usage - Prompt Tokens: {}, Completion Tokens: {}, Total Tokens: {}",
                promptTokens, completionTokens, totalTokens);
        return chatClientResponse;
    }

    @Override
    public Flux<ChatClientResponse> adviseStream(ChatClientRequest chatClientRequest, StreamAdvisorChain streamAdvisorChain) {
        return null;
    }

    @Override
    public String getName() {
        return "TokenUsageAuditAdvisors";
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
