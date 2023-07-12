package com.gihtub.onechesz.gpt_therapy.util.api_models;

import com.google.gson.annotations.SerializedName;

public class JsonGptAnswer {
    @SerializedName(value = "reply")
    private String reply;
    @SerializedName(value = "question_1")
    private String questionOne;
    @SerializedName(value = "question_2")
    private String questionTwo;
    @SerializedName(value = "question_3")
    private String questionThree;

    public JsonGptAnswer() {

    }

    public JsonGptAnswer(String reply, String questionOne, String questionTwo, String questionThree) {
        this.reply = reply;
        this.questionOne = questionOne;
        this.questionTwo = questionTwo;
        this.questionThree = questionThree;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getQuestionOne() {
        return questionOne;
    }

    public void setQuestionOne(String questionOne) {
        this.questionOne = questionOne;
    }

    public String getQuestionTwo() {
        return questionTwo;
    }

    public void setQuestionTwo(String questionTwo) {
        this.questionTwo = questionTwo;
    }

    public String getQuestionThree() {
        return questionThree;
    }

    public void setQuestionThree(String questionThree) {
        this.questionThree = questionThree;
    }
}
