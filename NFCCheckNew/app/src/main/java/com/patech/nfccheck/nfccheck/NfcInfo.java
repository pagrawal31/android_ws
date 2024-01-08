package com.patech.nfccheck.nfccheck;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import android.webkit.WebView;

import org.jetbrains.annotations.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pagrawal on 20-10-2017.
 */

public class NfcInfo extends BaseActivity {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.webView) WebView webHolder;
//    @BindView(R.id.adView) AdView mAdView;

    AdMobUtility utility;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_layout);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webHolder.loadUrl("file:///android_asset/1.1 Introduction.html");

//        utility = new AdMobUtility(this);
//        utility.setLayoutForSmartBanner();
//        AdView mAdView = utility.displaySmartBannerAdsForOrientationChange();
//        super.initAds(mAdView);

    }
}
