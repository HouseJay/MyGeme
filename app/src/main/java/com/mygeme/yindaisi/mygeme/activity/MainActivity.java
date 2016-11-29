package com.mygeme.yindaisi.mygeme.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import com.mygeme.yindaisi.mygeme.R;
import com.mygeme.yindaisi.mygeme.activity.builder.path.MBubbleBuilber;
import com.mygeme.yindaisi.mygeme.activity.com.mygeme.yindaisi.mygeme.view.Circle;
import com.mygeme.yindaisi.mygeme.activity.util.BubbleManager;
import com.mygeme.yindaisi.mygeme.databinding.ActivityMainBinding;

import java.util.List;

import static com.mygeme.yindaisi.mygeme.activity.appliction.Pardon.metrics;

/**
 * Created by 18224 on 2016/11/15.
 */

public class MainActivity extends BaseActivity {
    ActivityMainBinding mainBinding;
    WebView webView;
    Circle circle;
    int content ;
    int screen;
    int screenWidth;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            content = content+10;
            circle.setTranslationY(10+content);
            circle.setTranslationX(content);
            if(content > screen||content > screenWidth)
                content = 0;
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //获得一下屏幕的信息

        metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        screen = metrics.heightPixels;
        screenWidth = metrics.widthPixels;
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        myClickListener click = new myClickListener();
        mainBinding.setMyclick(click);
        webView = mainBinding.linShow;

        setCircle();
    }
    private void setCircle(){
        /**
         * 运用builder模式构建一个bubblemanager
         * */
        MBubbleBuilber mbubble = new MBubbleBuilber(getApplicationContext());
        mbubble.setDensity(0.5f);
        mbubble.setMaxCircle(30);
        mbubble.setSpeed(1f);
        BubbleManager bubbleManager = mbubble.builder();
        bubbleManager.start(mainBinding.frlBoss);

//        circle = new Circle(MainActivity.this);
//        new Thread(new Timing()).start();
//        mainBinding.frlBoss.addView(circle,1);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && mainBinding.linShow.canGoBack()){
            mainBinding.linShow.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> data, Menu menu, int deviceId) {
        super.onProvideKeyboardShortcuts(data, menu, deviceId);
    }

    public class myClickListener implements View.OnClickListener{
        private boolean first = true;
        @SuppressLint({"JavascriptInterface","SetJavaScriptEnabled"})
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.but_showmyview:
                    if(first){
                        mainBinding.linShow.setVisibility(View.VISIBLE);

                        webView.getSettings().setJavaScriptEnabled(true);

                        webView.addJavascriptInterface(new MyJavaScriptObject(MainActivity.this),"contact");
                        mainBinding.linShow.loadUrl("file:///android_asset/myweb.html");
                        /*ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) getResources().getDimension(R.dimen.dimen_200));
                        webView.setLayoutParams(layoutParams);
                        mainBinding.linShow.addView(webView);*/
                        first = false;
                    }else {
                        webView.setVisibility(View.INVISIBLE);
                        first = true;
                    }
                    break;
            }
        }
    }

    public final class MyJavaScriptObject{
        Context context;
        public MyJavaScriptObject(Context context){
            this.context = context;
        }

        @JavascriptInterface
        public void startNewActivity(){
            Log.e("Jay","调用过这个方法");
            Intent intent = new Intent("com.housejay.mysecond");
            MainActivity.this.startActivity(intent);
        }
    }
    public class Timing implements Runnable{
        @Override
        public void run() {
            Message mes ;
            while(true){
                try {
                    Thread.sleep(100);
                    mes = Message.obtain();
                    handler.sendMessage(mes);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
