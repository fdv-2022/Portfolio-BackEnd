package com.test.demo.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table
public class Proyecto {
    @Id
    private Long id;
    private Long userId;
    private String imageLink;
    private String title;
    private String description;
    private String proyectLink;

    public Proyecto() {
    }

    public Proyecto(Long id, Long userId, String imageLink, String title, String description, String proyectLink) {
        this.id = id;
        this.userId = userId;
        this.imageLink = imageLink;
        this.title = title;
        this.description = description;
        this.proyectLink = proyectLink;
    }

    public Proyecto(Long userId, String imageLink, String title, String description, String proyectLink) {
        this.userId = userId;
        this.imageLink = imageLink;
        this.title = title;
        this.description = description;
        this.proyectLink = proyectLink;
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

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProyectLink() {
        return proyectLink;
    }

    public void setProyectLink(String link) {
        this.proyectLink = link;
    }
}
