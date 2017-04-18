package com.sunfusheng.StickyHeaderListView.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.sunfusheng.StickyHeaderListView.R;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        WebView webView = (WebView) findViewById(R.id.webview);
        webView.loadUrl("http://geeksperm.com/register/");
}
}
