package com.vanyailnitsk.scoreboard.tasks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vanyailnitsk.scoreboard.models.User;
import jakarta.persistence.*;

@Entity
@Table
public class AlgorithmTaskResult {
    @Id
    @GeneratedValue
    private Integer algorithmResultId;

    private boolean isCorrect;

    @ManyToOne
    @JoinColumn(name = "userId")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "algorithmTaskId")
    private AlgorithmTask algorithmTask;

    public AlgorithmTaskResult() {
    }

    public AlgorithmTaskResult(User user, AlgorithmTask algorithmTask, boolean isCorrect) {
        this.isCorrect = isCorrect;
        this.user = user;
        this.algorithmTask = algorithmTask;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AlgorithmTask getAlgorithmTask() {
        return algorithmTask;
    }

    public void setAlgorithmTask(AlgorithmTask algorithmTask) {
        this.algorithmTask = algorithmTask;
    }
}
