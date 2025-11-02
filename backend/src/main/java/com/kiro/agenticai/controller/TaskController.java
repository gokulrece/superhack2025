// package com.kiro.agenticai.controller;

// import com.kiro.agenticai.model.Task;
// import com.kiro.agenticai.service.TaskService;
// import org.springframework.web.bind.annotation.*;
// import java.util.List;

// @RestController
// @RequestMapping("/api/tasks")
// @CrossOrigin(origins = "*")
// public class TaskController {

//     private final TaskService service;

//     public TaskController(TaskService service) {
//         this.service = service;
//     }

//     @GetMapping
//     public List<Task> getAllTasks() {
//         return service.getAll();
//     }

//     @PostMapping
//     public Task createTask(@RequestBody Task task) {
//         return service.save(task);
//     }
// }

package com.kiro.agenticai.controller;

import com.kiro.agenticai.model.Task;
import com.kiro.agenticai.repository.TaskRepository;
import com.kiro.agenticai.service.OpenAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

    private final TaskRepository taskRepository;
    private final OpenAIService aiService;

    @Autowired
    public TaskController(TaskRepository taskRepository, OpenAIService aiService) {
        this.taskRepository = taskRepository;
        this.aiService = aiService;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        String inputText = "Task: " + task.getTitle() +
                "\nPriority: " + task.getPriority() +
                "\nStatus: " + task.getStatus() +
                "\nRelated To: " + task.getRelatedTo();

        String aiSummary = aiService.generateSummary(inputText);
        task.setSummary(aiSummary);

        return taskRepository.save(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable String id, @RequestBody Task task) {
        Task existing = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));

        existing.setTitle(task.getTitle());
        existing.setPriority(task.getPriority());
        existing.setStatus(task.getStatus());
        existing.setRelatedTo(task.getRelatedTo());

        // Regenerate AI summary
        String aiSummary = aiService.generateSummary(existing.getTitle() + " - " + existing.getPriority());
        existing.setSummary(aiSummary);

        return taskRepository.save(existing);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable String id) {
        taskRepository.deleteById(id);
    }
}
