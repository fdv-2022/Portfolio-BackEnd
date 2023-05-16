package com.test.demo.model;

import jakarta.persistence.*;

@Entity
@Table
public class Skills {
    @Id
    private Long id;
    private Long userId;
    private String skill;
    private String percentageString;

    public Skills() {
    }

    public Skills(Long id, Long userId, String skill, String percentageString) {
        this.id = id;
        this.userId = userId;
        this.skill = skill;
        this.percentageString = percentageString;
    }

    public Skills(Long userId, String skill, String percentageString) {
        this.userId = userId;
        this.skill = skill;
        this.percentageString = percentageString;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getPercentageString() {
        return percentageString;
    }

    public void setPercentageString(String percentageString) {
        this.percentageString = percentageString;
    }
}
