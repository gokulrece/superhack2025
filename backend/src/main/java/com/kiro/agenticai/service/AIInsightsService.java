package com.kiro.agenticai.service;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AIInsightsService {

    @Autowired(required = false)
    private ChatModel chatModel;

    public String summarize(String text) {
        try {
            if (chatModel == null) {
                return "⚙️ (AI Offline) No active ChatModel. Showing local summary.";
            }

            PromptTemplate template = new PromptTemplate("Summarize IT insights: {input}");
            Prompt prompt = template.create(Map.of("input", text));

            return chatModel.call(prompt).getResult().getOutput().getContent();

        } catch (Exception e) {
            System.err.println("⚠️ AI Summarization failed, using fallback. Cause: " + e.getMessage());
            return generateFallbackSummary(text);
        }
    }

    private String generateFallbackSummary(String text) {
        // Simple local heuristic summary for demo when API quota exceeded
        if (text.toLowerCase().contains("alert"))
            return "Detected critical alerts in IT systems. Manual review recommended.";
        if (text.toLowerCase().contains("patch"))
            return "Patches applied with mixed results. Rollback candidates found.";
        if (text.toLowerCase().contains("task"))
            return "Several maintenance tasks are pending. Prioritize by impact.";
        return "System stable. No critical issues detected.";
    }
}
