package com.notein.notein.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Document(collection = "notes")
public class Note implements Serializable {
    @Id
    private String id;
    private Instant date = Instant.now();
    private String title;
    private String text;

    public Note(String id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public Note() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Note note)) return false;
        return Objects.equals(getId(), note.getId()) && Objects.equals(getDate(), note.getDate()) && Objects.equals(getTitle(), note.getTitle()) && Objects.equals(getText(), note.getText());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDate(), getTitle(), getText());
    }

}
