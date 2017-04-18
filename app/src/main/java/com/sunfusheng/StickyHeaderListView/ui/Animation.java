package com.sunfusheng.StickyHeaderListView.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.AnimationUtils;

import com.sunfusheng.StickyHeaderListView.R;

public class Animation extends Activity {
    android.view.animation.Animation screen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainstart);

        screen = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.logoanim);
        screen = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button);
    }
}
