package com.vanyailnitsk.scoreboard.tasks;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class TestTask {
    @Id
    @GeneratedValue
    private Integer testId;
    private String title;

    @OneToMany(mappedBy = "test")
    private List<TestQuestion> questions;

    public TestTask() {
    }

    public TestTask(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<TestQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<TestQuestion> questions) {
        this.questions = questions;
    }
}
