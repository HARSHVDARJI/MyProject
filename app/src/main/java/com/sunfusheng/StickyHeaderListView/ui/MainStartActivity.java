package com.sunfusheng.StickyHeaderListView.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.sunfusheng.StickyHeaderListView.R;

public class MainStartActivity extends Activity {
    Button login,signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainstart);
        StartAnimations();

        login = (Button)findViewById(R.id.login);
        signup = (Button)findViewById(R.id.signup);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainStartActivity.this, FinagerprintActvity.class);
                startActivity(i);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainStartActivity.this, Signup.class);
                startActivity(i);
            }
        });
    }
    private void StartAnimations() {
        android.view.animation.Animation anim = AnimationUtils.loadAnimation(this, R.anim.logoanim);
        ImageView iv = (ImageView) findViewById(R.id.logo99);
        iv.clearAnimation();
        iv.startAnimation(anim);

        android.view.animation.Animation anim1 = AnimationUtils.loadAnimation(this, R.anim.button);
        LinearLayout l = (LinearLayout) findViewById(R.id.lin_lay);
        l.clearAnimation();
        l.startAnimation(anim1);


    }


}
