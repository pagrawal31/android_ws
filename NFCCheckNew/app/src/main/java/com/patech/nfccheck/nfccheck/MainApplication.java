package com.patech.nfccheck.nfccheck;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.patech.utils.AppConstants;
import com.patech.utils.AppUtils;

public class MainApplication extends Application {

//    private AdRequest adRequest;
    protected SharedPreferences prefs;
    private boolean adViewInit = false;

    @Override
    public void onCreate() {
        super.onCreate();
//        FirebaseApp.initializeApp(this);
  //      adRequest = null;
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
    }
/*
    public void initAds(AdView mAdView) {
        if (mAdView == null)
            return;

        String admobUserId = prefs.getString(AppUtils.KEY_ADMOB_USER_ID, AppConstants.EMPTY);
        String admobBannerId = prefs.getString(AppUtils.KEY_ADMOB_BANNER_ID, AppConstants.EMPTY);

        if (AppUtils.isEmpty(admobUserId) || AppUtils.isEmpty(admobBannerId)) {
//            admobUserId = "ca-app-pub-9051732750570543~2282656719";
            admobUserId = "ca-app-pub-9051732750570543~9306618651";
//            admobBannerId = getString(R.string.banner_ad_unit_id_test);
            // admobBannerId = "ca-app-pub-9051732750570543/6930625965";
            // above is older
            admobBannerId = "ca-app-pub-9051732750570543/2741210306";
        }
        mAdView.setAdUnitId(admobBannerId);

        if (adRequest == null) {
            synchronized (this) {
                if (adRequest == null) {

                    // Ad begins
                    if (!adViewInit) {
                        MobileAds.initialize(this, admobUserId);
                        adViewInit = true;
                    }

                    AdRequest.Builder adRequestBldr = new AdRequest.Builder();
                    if (BuildConfig.DEBUG) {
                        adRequestBldr.addTestDevice("BB1F5B03449C97D094E3C46CAC849DAF");
                        //
//                        adRequestBldr.addTestDevice("C5241EE35056CBC8997286B237168615");
//                        adRequestBldr.addTestDevice("1CB02CB87A6BC9C11259569AAE1C84AC");
                    }
                    adRequest = adRequestBldr.build();
                }
            }
        }
        mAdView.loadAd(adRequest);
    }
*/
    protected void persistValue(final String key, final String value) {
        prefs.edit().putString(key, value).commit();
    }

    protected void persistValue(final String key, final boolean value) {
        prefs.edit().putBoolean(key, value).commit();
    }
}
