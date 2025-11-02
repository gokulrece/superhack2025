package com.kiro.agenticai.controller;

import com.kiro.agenticai.model.Patch;
import com.kiro.agenticai.repository.PatchRepository;
import com.kiro.agenticai.service.OpenAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patches")
@CrossOrigin(origins = "*")
public class PatchController {

    private final PatchRepository patchRepository;
    private final OpenAIService aiService;

    @Autowired
    public PatchController(PatchRepository patchRepository, OpenAIService aiService) {
        this.patchRepository = patchRepository;
        this.aiService = aiService;
    }

    @GetMapping
    public List<Patch> getAllPatches() {
        return patchRepository.findAll();
    }

    @PostMapping
    public Patch createPatch(@RequestBody Patch patch) {
        // Use OpenAI to generate a smart summary
        String inputText = "Patch: " + patch.getName() +
                "\nImpact: " + patch.getImpact() +
                "\nStatus: " + patch.getStatus() +
                "\nConflict: " + patch.getConflict();

        String aiSummary = aiService.generateSummary(inputText);
        patch.setSummary(aiSummary);

        return patchRepository.save(patch);
    }

    @PutMapping("/{id}")
    public Patch updatePatch(@PathVariable String id, @RequestBody Patch patch) {
        Patch existing = patchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patch not found with id: " + id));

        existing.setName(patch.getName());
        existing.setImpact(patch.getImpact());
        existing.setStatus(patch.getStatus());
        existing.setConflict(patch.getConflict());

        // Regenerate summary
        String aiSummary = aiService.generateSummary(existing.getName() + " - " + existing.getImpact());
        existing.setSummary(aiSummary);

        return patchRepository.save(existing);
    }

    @DeleteMapping("/{id}")
    public void deletePatch(@PathVariable String id) {
        patchRepository.deleteById(id);
    }
}
