package com.patech.nfccheck.nfccheck;


import android.app.Activity;
import android.graphics.Point;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;

import androidx.core.view.ViewCompat;

public class AdMobUtility {
    Activity activity;
    RelativeLayout adLayout;
//    AdLayout amzAdLayout;

    public AdMobUtility(Activity activity) {
        this.activity = activity;
//        adLayout = (RelativeLayout) activity.findViewById(R.id.footer);
    }

    public void setLayoutForSmartBanner() {
        int _400dpInPx = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                400, activity.getResources().getDisplayMetrics());
        int _720dpInPx = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                720, activity.getResources().getDisplayMetrics());

        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int screenHInPx = size.y;
        int adsLayoutHeightInDp = 0;
        if (screenHInPx < _400dpInPx) {
            adsLayoutHeightInDp = 32;
        } else if (screenHInPx >= _400dpInPx && screenHInPx <= _720dpInPx) {
            adsLayoutHeightInDp = 50;
        } else {
            adsLayoutHeightInDp = 90;
        }
        adLayout.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                adsLayoutHeightInDp,  activity.getResources().getDisplayMetrics());
        adLayout.requestLayout();
    }

    public Object displaySmartBannerAdsForOrientationChange() {
        setLayoutForSmartBanner();
//        AdView mAdView = new AdView(activity);
//        RelativeLayout.LayoutParams params =  new RelativeLayout
//                .LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
//        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
//        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
//        mAdView.setLayoutParams(params);
//        mAdView.setId(ViewCompat.generateViewId());
//        mAdView.setAdSize(AdSize.SMART_BANNER);
        //

//        this.amzAdLayout = new AdLayout(activity);
//        RelativeLayout.LayoutParams params =  new RelativeLayout
//                .LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
//        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
//        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
//
//        this.amzAdLayout.setLayoutParams(params);
//        LinearLayout layout = (LinearLayout) findViewById(R.id.mainLayout);
//        // Set the correct width and height of the ad
//        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.MATCH_PARENT);
        //
//        adLayout.addView(this.amzAdLayout);
//        AdTargetingOptions adOptions = new AdTargetingOptions();
//        boolean retValue = this.amzAdLayout.loadAd(adOptions); // Retrieves an ad on background thread
//        Log.d("Loading Ad value", String.valueOf(retValue));
//
//        return this.amzAdLayout;
        return null;
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);
    }
}
