package com.kiro.agenticai.service;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpenAIService {

    private final OpenAiChatModel chatModel;

    @Autowired
    public OpenAIService(OpenAiChatModel chatModel) {
        this.chatModel = chatModel;
    }

    // Generate AI summary for a given text input
    public String generateSummary(String input) {
        String promptText = "Summarize the following IT patch/task details in 3 concise lines:\n\n" + input;
        Prompt prompt = new Prompt(promptText);

        ChatResponse response = chatModel.call(prompt);
        return response.getResult().getOutput().getContent();
    }
}
