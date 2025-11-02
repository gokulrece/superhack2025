package com.kiro.agenticai.service;

import com.kiro.agenticai.model.Alert;
import com.kiro.agenticai.repository.AlertRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlertService {
    private final AlertRepository repo;
    public AlertService(AlertRepository repo) { this.repo = repo; }

    public List<Alert> getAll() { return repo.findAll(); }
    public Alert save(Alert a) { return repo.save(a); }
}
