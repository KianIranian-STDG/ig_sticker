package com.vanniktech.emoji.sticker;

import android.content.Context;
import android.util.AttributeSet;

import com.airbnb.lottie.LottieAnimationView;

public class LottieStickerView extends LottieAnimationView {
    public LottieStickerView(Context context) {
        super(context);
    }

    public LottieStickerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LottieStickerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
    }
}
