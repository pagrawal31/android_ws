package com.patech.tutorial;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import com.patech.nfccheck.nfccheck.BaseActivity;
import com.patech.nfccheck.nfccheck.AdMobUtility;
import com.patech.nfccheck.nfccheck.R;
import com.patech.utils.AppUtils;

import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ChapterActivity extends BaseActivity {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.webView) WebView webHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();
        String filePath = i.getStringExtra(AppUtils.PATH);
        setTitle(filePath);

        String path = "file:///android_asset/" + TutorialUtils.PATH_IN_ASSESTS_DIR + TutorialUtils.PATH_SEPARATOR + filePath;
        webHolder.loadUrl(path);
        webHolder.getSettings().setBuiltInZoomControls(true);
        webHolder.getSettings().setDisplayZoomControls(false);
    }
}
