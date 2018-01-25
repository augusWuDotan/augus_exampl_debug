package com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Spell;

import com.wdtpr.augus.bjprofile.R;
import com.wdtpr.augus.bjprofile.bjDemo.adapter.factory.IItemType;

import java.io.Serializable;

/**
 * Created by augus on 2018/1/24.
 */

public class DealItem implements Serializable, IItemType {
    public static final int SPELL_DEAL_ITEM = R.layout.adapter_spell_child_item;

    private String type;
    private float hw;

    @Override
    public int itemType() {
        return SPELL_DEAL_ITEM;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getHw() {
        return hw;
    }

    public void setHw(float hw) {
        this.hw = hw;
    }
}
