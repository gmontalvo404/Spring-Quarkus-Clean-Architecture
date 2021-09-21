package org.example.songs;

import java.io.Serializable;
import java.time.LocalDate;

public class Song implements Serializable {

    private Long id;

    private String name;

    private Long duration;

    private Boolean available;

    private LocalDate publicationDate;

    public Song() {
    }

    public Song(String name, Long duration, Boolean available, LocalDate publicationDate) {
        this.name = name;
        this.duration = duration;
        this.available = available;
        this.publicationDate = publicationDate;
    }

    public Song(Long id, String name, Long duration, Boolean available, LocalDate publicationDate) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.available = available;
        this.publicationDate = publicationDate;
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

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }
}
