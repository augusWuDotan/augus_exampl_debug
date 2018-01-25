package com.wdtpr.augus.bjprofile.bjDemo.model.viewHolder;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.wdtpr.augus.bjprofile.R;
import com.wdtpr.augus.bjprofile.bjDemo.adapter.base.BaseViewHolder;
import com.wdtpr.augus.bjprofile.bjDemo.glide.GlideApp;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Spell.DealItem;


/**
 * Created by Ray on 2017/8/22.
 * ArticleProfileViewHolder
 */

public class SpellChildViewHolder extends BaseViewHolder {
    private ConstraintLayout cl;
    private ImageView iv;


    public SpellChildViewHolder(View itemView) {
        super(itemView);
        cl = (ConstraintLayout) getView(R.id.cl);
        iv = (ImageView) getView(R.id.iv);
    }

    @Override
    public View[] getClickViews() {
        return new View[0];
    }

    @Override
    public View[] getLongClickViews() {
        return new View[0];
    }

    @Override
    public void bindViewData(Context context, Object data, int itemPosition, int finalPosition) {
        final DealItem bean = (DealItem) data;

        ViewGroup.LayoutParams lp = cl.getLayoutParams();
        lp.height = (int) bean.getHw();
        lp.width = (int) bean.getHw();
        cl.setLayoutParams(lp);

        switch (bean.getType()) {
            case "red":
                GlideApp.with(context).asBitmap().load(R.drawable.spell_red).error(R.drawable.spell_gray).into(iv);
                break;
            case "green":
                GlideApp.with(context).asBitmap().load(R.drawable.spell_green).error(R.drawable.spell_gray).into(iv);
                break;
            case "gray":
                GlideApp.with(context).asBitmap().load(R.drawable.spell_gray).error(R.drawable.spell_gray).into(iv);
                break;
        }
    }

}
