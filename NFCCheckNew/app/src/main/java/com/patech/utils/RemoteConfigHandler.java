package com.patech.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


import androidx.annotation.NonNull;

public class RemoteConfigHandler {

    private static final String TAG = RemoteConfigHandler.class.getSimpleName();

    private Context context;
    protected SharedPreferences prefs;

    public static Builder with(@NonNull Context context) {
        return new Builder(context);
    }

    public RemoteConfigHandler(@NonNull Context context) {
        this.context = context;
        prefs = PreferenceManager.getDefaultSharedPreferences(this.context);
    }

//    public void check() {
//        final FirebaseRemoteConfig remoteConfig = FirebaseRemoteConfig.getInstance();
//        String admobUserId = remoteConfig.getString(AppUtils.KEY_ADMOB_USER_ID);
//        String admobBannerId = remoteConfig.getString(AppUtils.KEY_ADMOB_BANNER_ID);
//        if (!AppUtils.isEmpty(admobUserId)) {
//            persistValue(AppUtils.KEY_ADMOB_USER_ID, admobUserId);
//        }
//        if (!AppUtils.isEmpty(admobBannerId)) {
//            persistValue(AppUtils.KEY_ADMOB_BANNER_ID, admobBannerId);
//        }
//    }

    public static class Builder {

        private Context context;

        public Builder(Context context) {
            this.context = context;
        }

        public RemoteConfigHandler build() {
            return new RemoteConfigHandler(context);
        }

        public RemoteConfigHandler check() {
            RemoteConfigHandler remoteConfigHandler = build();
//            remoteConfigHandler.check();

            return remoteConfigHandler;
        }
    }

    protected void persistValue(final String key, final String value) {
        prefs.edit().putString(key, value).commit();
    }
}