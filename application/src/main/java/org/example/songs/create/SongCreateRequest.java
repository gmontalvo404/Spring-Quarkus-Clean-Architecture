package org.example.songs.create;

import java.time.LocalDate;

public class SongCreateRequest {

    private String name;

    private Long minutes;

    private Long seconds;

    private Boolean available;

    private LocalDate publicationDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMinutes() {
        return minutes;
    }

    public void setMinutes(Long minutes) {
        this.minutes = minutes;
    }

    public Long getSeconds() {
        return seconds;
    }

    public void setSeconds(Long seconds) {
        this.seconds = seconds;
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
