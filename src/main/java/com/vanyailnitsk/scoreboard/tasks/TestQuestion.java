package com.vanyailnitsk.scoreboard.tasks;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class TestQuestion {
    @Id
    @GeneratedValue
    private Integer questionId;

    @ManyToOne
    @JoinColumn(name = "testId")
    private TestTask test;

    @ElementCollection
    @CollectionTable(name = "test_task_options", joinColumns = @JoinColumn(name = "questionId"))
    @Column(name = "option")
    private List<String> options;
    private Integer correctId;

    public TestQuestion() {
    }

    public TestTask getTest() {
        return test;
    }

    public void setTest(TestTask test) {
        this.test = test;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public Integer getCorrectId() {
        return correctId;
    }

    public void setCorrectId(Integer correctId) {
        this.correctId = correctId;
    }
}
