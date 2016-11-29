package com.mygeme.yindaisi.mygeme.activity.com.mygeme.yindaisi.mygeme.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.mygeme.yindaisi.mygeme.R;

import java.util.Random;

/**
 * Created by 18224 on 2016/11/22.
 * 圆型的泡泡
 *  会要求一个最大圆的值和最小圆值，
 *      圆型的泡泡定义三个到五个。不同的透明度，
 *      @pasue  int maxR
 *      @pasue  int minR
 *      @pasue int maxAlpha
 *      @pasue int minAlpha
 *      @pasue Random ran;
 *      @pasue TypeArray typearray;
 *
 */

public class Circle extends View{
    private int maxR;
    private int minR;
    private float maxAlpha;
    private float minAlpha;
    private Random ran;
    private Context mContext;

    public Circle(Context context){
        super(context);
        //获得了屏幕的宽高
        mContext = context;
    }

    public Circle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        //获得XML中属性
//        TypedArray array = context.obtainStyledAttributes(attrs,R.styleable.Circle);
//        maxR = array.getDimensionPixelOffset(R.styleable.Circle_max_r,15);
//        minR = array.getDimensionPixelOffset(R.styleable.Circle_min_r,10);
//        maxAlpha = array.getDimension(R.styleable.Circle_max_alpha,1);
//        minAlpha = array.getDimension(R.styleable.Circle_min_alpha,1);
//        array.recycle();

    }


    @Override
    protected void onDraw(Canvas canvas) {
        //得到一个Drawable对象
        Drawable drawable = ContextCompat.getDrawable(mContext, R.mipmap.bulin);
        //得到里面的Bitmap对象
       Bitmap bitmap =((BitmapDrawable)drawable).getBitmap();


        Bitmap newbitmap = Bitmap.createScaledBitmap(bitmap,50,50,false);

        BitmapShader shader = new BitmapShader(newbitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(shader);
        canvas.drawCircle(25,25,25,paint);

//        canvas.drawRoundRect(new RectF(0,0,40,40),20,20,new Paint(Paint.ANTI_ALIAS_FLAG));
       /* Canvas myCanvas = new Canvas();
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLUE);
        myCanvas.drawRoundRect(new RectF(0,0,20,20),8,8,paint);*/
    }
}
