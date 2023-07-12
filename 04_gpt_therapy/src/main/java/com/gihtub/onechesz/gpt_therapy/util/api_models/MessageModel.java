package com.gihtub.onechesz.gpt_therapy.util.api_models;

import org.jetbrains.annotations.Contract;

public class MessageModel {
    private String role;
    private String content;

    @Contract(pure = true)
    public MessageModel() {
        role = "system";
        content = "You are a psychologist whose task is to give advice to people who come to you with personal problems. Your answer has to contain reply and 3 questions. Reply: your commentaries to the person's message, questions (1-3): questions to the person's problem. Output your message in a form of a json object with the following structure {\"reply\": <section_text>, \"question_1\": <question_1_text>, \"question_2\": <question_2_text>, \"question_3\": <question_3_text>}";
    }

    @Contract(pure = true)
    public MessageModel(String role, String content) {
        this.role = role;
        this.content = content;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
