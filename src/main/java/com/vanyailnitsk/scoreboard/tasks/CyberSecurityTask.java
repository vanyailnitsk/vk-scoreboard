package com.vanyailnitsk.scoreboard.tasks;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class CyberSecurityTask {
    @Id
    @GeneratedValue
    private Integer cyberTaskId;
    private String title;
    private String condition;

    public CyberSecurityTask() {
    }

    public CyberSecurityTask(String title, String condition) {
        this.title = title;
        this.condition = condition;
    }

    public CyberSecurityTask(String title) {
        this.title = title;
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
}
