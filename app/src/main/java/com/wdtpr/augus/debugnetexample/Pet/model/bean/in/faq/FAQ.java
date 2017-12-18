package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.faq;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/4.
 */

public class FAQ implements Serializable {
    /*
    {
      "id": 8,
      "question": "TQ1.1",
      "anwser": "TA1.1"
    }
     */
    private int id ;
    private String question;
    private String anwser;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnwser() {
        return anwser;
    }

    public void setAnwser(String anwser) {
        this.anwser = anwser;
    }

    @Override
    public String toString() {
        return "FAQ{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", anwser='" + anwser + '\'' +
                '}';
    }
}
