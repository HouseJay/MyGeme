package com.mygeme.yindaisi.mygeme.activity.com.mygeme.yindaisi.mygeme.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 18224 on 2016/11/22.
 * 圆型的泡泡
 *  会要求一个最大圆的值和最小圆值，
 *      圆型的泡泡定义三个到五个。不同的透明度，
 *      @pasue  int maxR
 *      @pasue  int minR
 *      @pasue int maxAlpha
 *      @pasue int minAlpha
 *      @pasue Randram ran;
 *
 */

public class Circle extends View{

    public Circle(Context context) {
        super(context);
    }

    public Circle(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Circle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRoundRect(new RectF(0,0,20,20),10,10,new Paint(Paint.ANTI_ALIAS_FLAG));
        super.onDraw(canvas);
    }
}
