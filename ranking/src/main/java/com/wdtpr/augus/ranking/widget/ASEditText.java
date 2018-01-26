package com.wdtpr.augus.ranking.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.wdtpr.augus.ranking.R;
import com.wdtpr.augus.ranking.utils.LogUtils;

/**
 * Created by augus on 2017/7/3.
 * ASEditText
 */

public class ASEditText extends android.support.v7.widget.AppCompatEditText implements TextWatcher {
    private static final String TAG = ASEditText.class.getSimpleName();
    private Drawable rightDrawable, leftDrawable;
    private int wh;
    private Paint paint;

    int left;
    int right;
    int top;
    int bottom;


    public ASEditText(Context context) {
        super(context);
        initLeftDrawable(context);
    }

    public ASEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLeftDrawable(context);

    }

    public ASEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        wh = bottom - top - 2;
        leftDrawable.setBounds(0 , 0, wh , wh);
        setCompoundDrawables(leftDrawable, null, null, null);
        //
//        LogUtils.d("left:" + left);
//        LogUtils.d("right:" + right);
//        LogUtils.d("top:" + top);
//        LogUtils.d("bottom:" + bottom);

        this.left = left;
        this.right = right;
        this.bottom = bottom;
        this.top = top;

        int w = right - left;
        int h = bottom - top;
//        LogUtils.d("w:" + w);
//        LogUtils.d("h:" + h);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }


    private void initLeftDrawable(Context context) {
        leftDrawable = context.getResources().getDrawable(android.R.drawable.ic_menu_search);
        leftDrawable.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (s.length() > 0) {
            setCompoundDrawables(leftDrawable, null, rightDrawable, null);
        } else {
            setCompoundDrawables(leftDrawable, null, null, null);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                float x = event.getX();
                float y = event.getY();
                float width = getWidth();
                float height = getHeight();
                if (rightDrawable != null) {
                    Rect rect = rightDrawable.getBounds();
                    float left = width - rect.right;
                    float top = height - rect.bottom;
                    if (x >= left && x <= width && y >= top && y <= height && getText().length() > 0) {
                        setText("");
                        return true;
                    }
                }
        }
        return super.onTouchEvent(event);
    }

    public void setDeleteDrawable(Drawable drawable, int size) {
        this.rightDrawable = drawable;
        if (this.rightDrawable != null) {
            this.rightDrawable.setBounds(0, 0, wh, wh);
        }
    }
}
