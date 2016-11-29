package com.mygeme.yindaisi.mygeme.activity.util;

import android.content.Context;
import android.view.ViewGroup;

import com.mygeme.yindaisi.mygeme.activity.appliction.Pardon;
import com.mygeme.yindaisi.mygeme.activity.com.mygeme.yindaisi.mygeme.view.Circle;
import com.mygeme.yindaisi.mygeme.activity.minterface.MBubbleManager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 18224 on 2016/11/27.
 * 够思：
 *      这个是一个管理类，所有用的方法应该是改变这个里面的参数达到改变屏幕上的
 *泡泡的数量，方向，速度的效果，所以，这些数据会在改变了之后就把里面的 Clicle对象清空，
 * 然后再重新的生成，
 *
 *  我需要一个线程池，这个是帮助我管理对象以及对象的生成
 *
 *      参数设置传入！！！
 *
 *      生成，线程进行动画
 *
 *   而在这里主要是控制生成多少个线程，线程生成多少个对象的控制，以及对里面传入的参数的控制。
 *
 *
 */

public class BubbleManager implements MBubbleManager {
    private int max = 30,min;
    private float speed;
    private float density;
    private int time = 200;

    private ExecutorService  executor;

    private Context context;
    /**
     * 这两个是必须的两个参数，所以不用构建者模式构建
     * */
    public BubbleManager (Context context){
        this.context = context;
    }

    @Override
    public BubbleManager setApparNum(int max, int min) {
        this.max = max;
        this.min = min;
        return this;
    }

    @Override
    public BubbleManager inputManager(Circle circle) {

        return this;
    }

    @Override
    public BubbleManager setSpeed(float speed) {
        this.speed = speed;
        return this;
    }

    @Override
    public BubbleManager setDensity(float density) {
        this.density = density;
        return this;
    }

    public BubbleManager setMax(int max){
        this.max = max;
        return this;
    }

    public BubbleManager setMin(int min){
        this.min = min;
        return this;
    }
    public void start(ViewGroup person){
        executor = Executors.newCachedThreadPool();
        int chx = Pardon.metrics.widthPixels/max;
        int index = 0;
        for(int i = 0;i < max ;i++){
            Circle circle = new Circle(context);
            person.addView(circle);
            circle.setTranslationX(index);
            executor.execute(new BubbleRun(circle,time,0,5,2));
            index = index + chx;
        }
    }


    class BubbleRun implements Runnable{
        private Circle circle;
        private int time;
        private int move;
        private int distance;
        private int jilu;
        private int zhou;

        private BubbleRun(Circle circle ,int time,int move,int distance,int zhou){
            this.circle = circle;
            this.move = move;
            this.distance = distance;
            this.zhou = zhou;
        }


        @Override
        public void run() {
            switch(zhou){
                case 1:
                    while(true) {
                        try {
                            Thread.sleep(time);
                            move = move + distance;
                            if(move > Pardon.metrics.widthPixels){
                                move = 0;
                            }
                            circle.post(new Runnable() {
                                @Override
                                public void run() {
                                    circle.setTranslationX(move);
                                }
                            });
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                case 2:
                    while(true) {
                        try {
                            Thread.sleep(time);
                            move = move + distance;
                            if(move > Pardon.metrics.heightPixels){
                                move = 0;
                            }
                            circle.post(new Runnable() {
                                @Override
                                public void run() {
                                    circle.setTranslationY(move);
                                }
                            });
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            }
        }
    }
}
