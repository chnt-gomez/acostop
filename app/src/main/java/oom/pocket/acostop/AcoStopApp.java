package oom.pocket.acostop;

import android.app.Application;

import com.facebook.FacebookSdk;

/**
 * Created by MAV1GA on 29/08/2017.
 */

public class AcoStopApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FacebookSdk.sdkInitialize(getApplicationContext());
    }
}
