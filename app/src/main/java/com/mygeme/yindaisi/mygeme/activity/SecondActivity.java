package com.mygeme.yindaisi.mygeme.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.mygeme.yindaisi.mygeme.R;
import com.mygeme.yindaisi.mygeme.databinding.ActivitySecondBinding;

/**
 * Created by 18224 on 2016/11/21.
 */

public class SecondActivity extends BaseActivity {
    ActivitySecondBinding secondBinding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        secondBinding = DataBindingUtil.setContentView(this, R.layout.activity_second);
        MyClickListener myClick = new MyClickListener();
        secondBinding.setMyClick(myClick);


    }
    public class MyClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            finish();
        }
    }
}
