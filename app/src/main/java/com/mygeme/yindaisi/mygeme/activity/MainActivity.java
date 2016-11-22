package com.mygeme.yindaisi.mygeme.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.mygeme.yindaisi.mygeme.R;
import com.mygeme.yindaisi.mygeme.databinding.ActivityMainBinding;

import java.util.List;

/**
 * Created by 18224 on 2016/11/15.
 */

public class MainActivity extends BaseActivity {
    ActivityMainBinding mainBinding;
    WebView webView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        myClickListener click = new myClickListener();
        mainBinding.setMyclick(click);
        webView = mainBinding.linShow;

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
                        webView.setVisibility(View.VISIBLE);
                        webView.loadUrl("file:///android_asset/myweb.html");

                        webView.getSettings().setJavaScriptEnabled(true);
                        webView.addJavascriptInterface(new MyJavaScriptObject(MainActivity.this),"contact");
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
    public class myWebClicent extends WebViewClient{

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
}
