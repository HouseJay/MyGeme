package com.mygeme.yindaisi.mygeme.activity.minterface;

import com.mygeme.yindaisi.mygeme.activity.com.mygeme.yindaisi.mygeme.view.Circle;
import com.mygeme.yindaisi.mygeme.activity.util.BubbleManager;

/**
 * Created by 18224 on 2016/11/27.
 * 泡泡管理接口
 */

public interface MBubbleManager {
    /**
     * 这个是为了定义出现在的个数，
     *
     * max 设置出现的最大 的数量
     *
     * min 设置出现的最小 的数量
     * */
    BubbleManager setApparNum(int max, int min);

    /**
     * 这个是初始化开始好了Circle然后放入Manager的方法
     *
     * circle 放入的对象
     * */
    BubbleManager inputManager(Circle circle);
    /**
     *speed 这个是设置速度 的方法, 在BubbleManager的方法里最大为：1
     *最小为0，为1就是最快的了，为0就不会动
     * */
    BubbleManager setSpeed(float speed);
    /**
     * density 现在的密度 ，@{#BubbleManager } 中1为最大 ，0为最小，
     *
     *      密度的判断取决于整个屏幕的数量，
     * */
    BubbleManager setDensity(float density);

}
