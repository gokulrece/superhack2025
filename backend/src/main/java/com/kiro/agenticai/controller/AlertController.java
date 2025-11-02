package com.kiro.agenticai.controller;

import com.kiro.agenticai.model.Alert;
import com.kiro.agenticai.service.AlertService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/alerts")
@CrossOrigin(origins = "*")
public class AlertController {
    private final AlertService service;
    public AlertController(AlertService service) { this.service = service; }

    @GetMapping
    public List<Alert> getAll() { return service.getAll(); }

    @PostMapping
    public Alert add(@RequestBody Alert alert) { return service.save(alert); }
}
