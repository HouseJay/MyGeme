package com.mygeme.yindaisi.mygeme.activity.util;

import com.mygeme.yindaisi.mygeme.activity.appliction.Pardon;

/**
 * Created by 18224 on 2016/11/24.
 */

public class MyUtil {
    //工具方法/px值转dp
    public static int pxToDb(int px){
        return (int)(Pardon.metrics.density+0.5f);
    }
}
