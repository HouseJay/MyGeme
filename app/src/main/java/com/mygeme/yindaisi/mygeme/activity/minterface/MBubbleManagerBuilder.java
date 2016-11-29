package com.mygeme.yindaisi.mygeme.activity.minterface;

/**
 * Created by 18224 on 2016/11/28.
 */

public interface MBubbleManagerBuilder {

    boolean setMaxCircle(int max);
    boolean setMinCircle(int min);
    boolean setSpeed(float speed);
    boolean setDensity(float density);
    MBubbleManager builder();
}
