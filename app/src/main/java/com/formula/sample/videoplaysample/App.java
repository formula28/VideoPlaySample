package com.formula.sample.videoplaysample;

import android.app.Application;
import android.content.Context;
import android.util.Log;

/**
 * Created by @formula on 2016/04/17.
 */
public class App extends Application {
    private static App mInstance;
    public static final String LOGTAG = "VIDEO_PLAYER";

    public static App getInstance()
    {
        Log.d(App.LOGTAG, mInstance.toString());
        return mInstance;
    }
    public App() {
        mInstance = this;
    }
}
