package com.example.sendmessageviewbinding;

import android.app.Application;
import android.util.Log;

public class MessageAplication  extends Application {
    public static final String TAG = "MessageAplication";
    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.d(TAG,"MessageApplication -> OnTerminate()");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"MessageApplication -> OnCreate()");
    }
}
