package com.gihtub.onechesz.gpt_therapy.util.api_models;

import org.jetbrains.annotations.Contract;

import java.util.ArrayList;
import java.util.List;

public class RequestModel {
    private String model;
    private List<MessageModel> messages;

    @Contract(pure = true)
    public RequestModel() {
        model = "gpt-3.5-turbo";
        messages = new ArrayList<>(List.of(new MessageModel()));
    }

    @Contract(pure = true)
    public RequestModel(String model, List<MessageModel> messages) {
        this.model = model;
        this.messages = messages;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<MessageModel> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageModel> messages) {
        this.messages = messages;
    }

    public void appendMessage(MessageModel message) {
        messages.add(message);
    }
}
