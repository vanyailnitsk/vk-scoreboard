package com.vanyailnitsk.scoreboard.tasks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vanyailnitsk.scoreboard.models.User;
import jakarta.persistence.*;

@Entity
@Table
public class CyberSecurityTaskResult {
    @Id
    @GeneratedValue
    private Integer cyberTaskResultId;
    private boolean isCorrest;
    @ManyToOne
    @JoinColumn(name = "cyberTaskId")
    private CyberSecurityTask task;

    @ManyToOne
    @JoinColumn(name = "userId")
    @JsonIgnore
    private User user;

    public CyberSecurityTaskResult() {
    }

    public CyberSecurityTaskResult(boolean isCorrest, CyberSecurityTask task, User user) {
        this.isCorrest = isCorrest;
        this.task = task;
        this.user = user;
    }

    public CyberSecurityTask getTask() {
        return task;
    }

    public void setTask(CyberSecurityTask task) {
        this.task = task;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
