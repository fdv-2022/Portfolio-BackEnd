package com.test.demo.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table
public class Persona {
    @Id
    private Long id;
    private String name;
    private Long userId;
    private String pictureLink;
    private String bannerLink;
    private String domicilio;
    private String subtitle;
    private String subtitleData;

    public Persona() {
    }

    public Persona(Long userId, String name, String domicilio, String subtitle, String subtitleData, String pictureLink, String bannerLink){
        this.name = name;
        this.userId = userId;
        this.pictureLink = pictureLink;
        this.bannerLink = bannerLink;
        this.domicilio = domicilio;
        this.subtitle = subtitle;
        this.subtitleData = subtitleData;
    }

    public Persona(Long id, Long userId, String name, String domicilio, String subtitle, String subtitleData, String pictureLink, String bannerLink){
        this.id = id;
        this.name = name;
        this.userId = userId;
        this.pictureLink = pictureLink;
        this.bannerLink = bannerLink;
        this.domicilio = domicilio;
        this.subtitle = subtitle;
        this.subtitleData = subtitleData;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPictureLink() {
        return pictureLink;
    }

    public void setPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
    }

    public String getBannerLink() {
        return bannerLink;
    }

    public void setBannerLink(String bannerLink) {
        this.bannerLink = bannerLink;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getSubtitleData() {
        return subtitleData;
    }

    public void setSubtitleData(String subtitleData) {
        this.subtitleData = subtitleData;
    }
}
