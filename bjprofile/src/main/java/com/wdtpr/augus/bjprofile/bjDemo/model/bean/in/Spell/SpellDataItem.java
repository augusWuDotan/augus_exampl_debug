package com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Spell;

import com.wdtpr.augus.bjprofile.R;
import com.wdtpr.augus.bjprofile.bjDemo.adapter.factory.IItemType;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2018/1/24.
 */

public class SpellDataItem implements Serializable,IItemType {
    public static final int SPELL_ITEM = R.layout.adapter_spell_form_item;
    /*
                {
                    "courseNo": "U1L1",
                    "lights": [
                        "red",
                        "green",
                        "green",
                        "green",
                        "green",
                        "green"
                    ]
                }
     */

    private String courseNo;
    private List<String> lights;

    @Override
    public int itemType() {
        return SPELL_ITEM;
    }

    @Override
    public String toString() {
        return "SpellDataItem{" +
                "courseNo='" + courseNo + '\'' +
                ", lights=" + lights +
                '}';
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public List<String> getLights() {
        return lights;
    }

    public void setLights(List<String> lights) {
        this.lights = lights;
    }
}
