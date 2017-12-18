package com.wdtpr.augus.debugnetexample.Pet.model.source.template;

/**
 * Created by augus on 2017/12/11.
 * 模板 類別
 */

public enum TemplateType {

    advertisement("advertisement"), store("store"), announcement("announcement"), lostSearch("lost-search");

    private String name;

    TemplateType(String name) {
        this.name = name;
    }
}
