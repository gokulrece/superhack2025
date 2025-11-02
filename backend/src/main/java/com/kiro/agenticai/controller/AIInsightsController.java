package com.kiro.agenticai.controller;
import com.kiro.agenticai.service.AIInsightsService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/ai")
@CrossOrigin(origins = "*")
public class AIInsightsController {
   private final AIInsightsService ai;
   public AIInsightsController(AIInsightsService ai) { this.ai = ai; }

    @PostMapping("/summarize")
    public Map<String, String> summarize(@RequestBody Map<String, String> body) {
        String text = body.getOrDefault("context", "No context provided");
        String summary = ai.summarize(text);
        return Map.of("summary", summary);
    }

}
