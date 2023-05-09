package com.vanyailnitsk.scoreboard.tasks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vanyailnitsk.scoreboard.models.User;
import jakarta.persistence.*;

@Entity
@Table
public class TestResult {
    @Id
    @GeneratedValue
    private Integer testScoreId;
    @ManyToOne
    @JoinColumn (name = "userId")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "testId")
    private TestTask test;

    private Integer score;
    public TestResult() {
    }

    public TestResult(TestTask test, Integer score) {
        this.test = test;
        this.score = score;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TestTask getTest() {
        return test;
    }

    public void setTest(TestTask test) {
        this.test = test;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
