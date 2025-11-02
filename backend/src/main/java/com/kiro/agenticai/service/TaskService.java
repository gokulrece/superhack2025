package com.kiro.agenticai.service;

import com.kiro.agenticai.model.Task;
import com.kiro.agenticai.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepository repo;
    public TaskService(TaskRepository repo) { this.repo = repo; }

    public List<Task> getAll() { return repo.findAll(); }
    public Task save(Task t) { return repo.save(t); }
}
