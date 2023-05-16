package com.test.demo.model;

import jakarta.persistence.*;

@Entity
@Table
public class Experiencia {
    @Id
    private Long id;

    private Long userId;

    private String place;

    private String durationString;

    public Experiencia() {
    }

    public Experiencia(Long id, Long userId, String place, String durationString) {
        this.id = id;
        this.userId = userId;
        this.place = place;
        this.durationString = durationString;
    }

    public Experiencia(Long userId, String place, String durationString) {
        this.userId = userId;
        this.place = place;
        this.durationString = durationString;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDurationString() {
        return durationString;
    }

    public void setDurationString(String durationString) {
        this.durationString = durationString;
    }
}
