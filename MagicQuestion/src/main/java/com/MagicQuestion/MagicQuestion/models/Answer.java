package com.MagicQuestion.MagicQuestion.models;

public class Answer {
    private int id;
    private Question question;
    private String answer;
    public Answer() {}

    public Answer(Question question, String answer, int id){
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getQuestion() +": "+ getAnswer();
    }
}
