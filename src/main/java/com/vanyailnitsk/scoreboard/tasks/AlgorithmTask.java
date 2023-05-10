package com.vanyailnitsk.scoreboard.tasks;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class AlgorithmTask {
    @Id
    @GeneratedValue
    private Integer algorithmTaskId;
    private String title;

    @Column(length = 500)
    private String condition;
    @ElementCollection
    @CollectionTable(joinColumns = @JoinColumn(name = "algorithmTaskId"))
    private List<String> examples;

    public AlgorithmTask() {
    }

    public AlgorithmTask(String title,String condition, List<String> examples) {
        this.title = title;
        this.condition = condition;
        this.examples = examples;
    }

    public AlgorithmTask(String title) {
        this.title = title;
    }

    public Integer getAlgorithmTaskId() {
        return algorithmTaskId;
    }

    public void setAlgorithmTaskId(Integer algorithmTaskId) {
        this.algorithmTaskId = algorithmTaskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public List<String> getExamples() {
        return examples;
    }

    public void setExamples(List<String> examples) {
        this.examples = examples;
    }
}
