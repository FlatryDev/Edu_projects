package com.gihtub.onechesz.gpt_therapy.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "emails")
public class EmailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "email")
    private String email;
    @Column(name = "story", nullable = false, length = 65535)
    private String story;
    @Column(columnDefinition = "json")
    private String gptAnswer;

    public EmailsEntity() {

    }

    public EmailsEntity(String story) {
        this.story = story;
    }

    public EmailsEntity(int id, String email, String story, String gptAnswer) {
        this.id = id;
        this.email = email;
        this.story = story;
        this.gptAnswer = gptAnswer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getGptAnswer() {
        return gptAnswer;
    }

    public void setGptAnswer(String gptAnswer) {
        this.gptAnswer = gptAnswer;
    }
}
