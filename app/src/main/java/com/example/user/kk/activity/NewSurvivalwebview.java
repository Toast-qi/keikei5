package com.example.user.kk.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.user.kk.R;

public class NewSurvivalwebview extends AppCompatActivity {
        WebView newvivalwebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_survival);

        newvivalwebView= (WebView) findViewById(R.id.Newsurvivalview);
        WebSettings setting = newvivalwebView.getSettings();
        setSettings(setting);
        newvivalwebView.setWebChromeClient(new WebChromeClient());
        newvivalwebView.setWebViewClient(new WebViewClient());
        newvivalwebView.loadUrl("http://www.kktv1.com/m/help/videoNewer.html");
    }

    private void setSettings(WebSettings setting){
        setting.setJavaScriptEnabled(true);
        setting.setBuiltInZoomControls(true);
        setting.setDisplayZoomControls(false);
        setting.setSupportZoom(true);


        setting.setDomStorageEnabled(true);
        setting.setDatabaseEnabled(true);
        setting.setLoadWithOverviewMode(true);
        setting.setUseWideViewPort(true);
    }
}
