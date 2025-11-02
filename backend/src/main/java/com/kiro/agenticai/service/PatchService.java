package com.kiro.agenticai.service;

import com.kiro.agenticai.model.Patch;
import com.kiro.agenticai.repository.PatchRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PatchService {
    private final PatchRepository repo;
    public PatchService(PatchRepository repo) { this.repo = repo; }

    public List<Patch> getAll() { return repo.findAll(); }
    public Patch save(Patch p) { return repo.save(p); }
}
