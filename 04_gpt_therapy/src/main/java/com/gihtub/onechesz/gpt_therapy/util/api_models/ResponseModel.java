package com.gihtub.onechesz.gpt_therapy.util.api_models;

import org.jetbrains.annotations.Contract;

import java.util.List;

public class ResponseModel {
    public static class Choice {
        private MessageModel message;

        @Contract(pure = true)
        public Choice() {

        }

        @Contract(pure = true)
        public Choice(MessageModel message) {
            this.message = message;
        }

        public MessageModel getMessage() {
            return message;
        }

        public void setMessage(MessageModel message) {
            this.message = message;
        }
    }

    private List<Choice> choices;

    @Contract(pure = true)
    public ResponseModel() {

    }

    @Contract(pure = true)
    public ResponseModel(List<Choice> choices) {
        this.choices = choices;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }
}
