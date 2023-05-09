package com.vanyailnitsk.scoreboard.controllers;

import com.vanyailnitsk.scoreboard.services.TaskService;
import com.vanyailnitsk.scoreboard.tasks.AlgorithmTask;
import com.vanyailnitsk.scoreboard.tasks.TestTask;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/algorithm/all")
    public List<AlgorithmTask> getAlgorithmTasks() {
        return taskService.getAlgorithmTasks();
    }

    @GetMapping("/test/all")
    public List<TestTask> getTestTasks() {
        return taskService.getTestTasks();
    }
}
