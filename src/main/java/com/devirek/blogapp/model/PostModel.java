package com.devirek.blogapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;

@Entity
@Table
public class PostModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column
    private String tittle;

    @Lob
    @Column
    @NotEmpty
    private String content;

    @Column
    @NotBlank
    private String authorName;

    @Column
    private Instant createdOn;

    @Column
    private Instant updatedOn;

    public Long getId() {
        return id;
    }

    public PostModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTittle() {
        return tittle;
    }

    public PostModel setTittle(String tittle) {
        this.tittle = tittle;
        return this;
    }

    public String getContent() {
        return content;
    }

    public PostModel setContent(String content) {
        this.content = content;
        return this;
    }

    public String getAuthorName() {
        return authorName;
    }

    public PostModel setAuthorName(String authorName) {
        this.authorName = authorName;
        return this;

    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public PostModel setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public Instant getUpdatedOn() {
        return updatedOn;
    }

    public PostModel setUpdatedOn(Instant updatedOn) {
        this.updatedOn = updatedOn;
        return this;
    }

    @Override
    public String toString() {
        return "UserPost{" + "id=" + id + ", tittle='" + tittle + '\'' + ", content='" + content + '\'' + ", authorName='" + authorName + '\'' + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + '}';
    }
}
