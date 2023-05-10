package com.vanyailnitsk.scoreboard.services;

import com.vanyailnitsk.scoreboard.repositories.AlgorithmTaskRepository;
import com.vanyailnitsk.scoreboard.repositories.CyberSecurityTaskRepository;
import com.vanyailnitsk.scoreboard.repositories.TestTaskRepository;
import com.vanyailnitsk.scoreboard.tasks.AlgorithmTask;
import com.vanyailnitsk.scoreboard.tasks.CyberSecurityTask;
import com.vanyailnitsk.scoreboard.tasks.TestTask;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final AlgorithmTaskRepository algorithmTaskRepository;
    private final TestTaskRepository testTaskRepository;
    private final CyberSecurityTaskRepository cyberSecurityTaskRepository;

    public TaskService(AlgorithmTaskRepository algorithmTaskRepository, TestTaskRepository testTaskRepository, CyberSecurityTaskRepository cyberSecurityTaskRepository) {
        this.algorithmTaskRepository = algorithmTaskRepository;
        this.testTaskRepository = testTaskRepository;
        this.cyberSecurityTaskRepository = cyberSecurityTaskRepository;
    }

    public List<AlgorithmTask> getAlgorithmTasks() {
       return algorithmTaskRepository.findAll();
    }

    public List<TestTask> getTestTasks() {
        return testTaskRepository.findAll();
    }
    public List<CyberSecurityTask> getCyberSecurityTasks() {
        return cyberSecurityTaskRepository.findAll();
    }

}
