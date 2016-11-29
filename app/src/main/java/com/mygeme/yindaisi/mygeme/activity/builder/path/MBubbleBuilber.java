package com.mygeme.yindaisi.mygeme.activity.builder.path;

import android.content.Context;
import android.util.Log;

import com.mygeme.yindaisi.mygeme.activity.minterface.MBubbleManagerBuilder;
import com.mygeme.yindaisi.mygeme.activity.util.BubbleManager;

/**
 * Created by 18224 on 2016/11/28.
 */

public class MBubbleBuilber implements MBubbleManagerBuilder {

    private int max = 10,min = 6;
    private float speed = 1;
    private float density = 1;

    private Context context;

    public MBubbleBuilber(Context context){
        this.context = context;
    }

    @Override
    public boolean setMaxCircle(int max) {
        if(max >100 ||max < min){
            Log.e("Jay", "max只能在min和100之间");
            return false;
        }else {
            this.max = max;
            return true;
        }
    }

    @Override
    public boolean setMinCircle(int min) {
        if(min < 0 || min > max){
            Log.e("Jay", "min只能在0和max之间");
            return false;
        }else{
            this.min = min;
            return true;
        }
    }

    @Override
    public boolean setSpeed(float speed) {
        if(speed > 1 ||speed < 0){
             Log.e("Jay", "speed只能在0和1之间");
            return false;
        }else {
            this.speed = speed;
            return true;
        }
    }

    @Override
    public boolean setDensity(float density) {
        if(density > 1 || density < 0){
            Log.e("Jay","density数字只能在0和1之间");
            return false;
        }else{
            this.density = density;
            return true;
        }
    }

    @Override
    public BubbleManager builder() {
        return new BubbleManager(context).setSpeed(speed).setDensity(density);
    }
}
