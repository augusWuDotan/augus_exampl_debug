package com.wdtpr.augus.debugnetexample.Pet.model.source.card;

/**
 * Created by augus on 2017/12/10.
 */

public enum CardService {

    big("大修"),small("小修"),either("其他");

    private String name;

    CardService(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
