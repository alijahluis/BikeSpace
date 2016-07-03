package com.capstone.bikespace;

import com.firebase.client.Firebase;
/**
 * Initialize Firebase here
 */
public class BikeSpaceApplication extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //~ Initialize firebase
        Firebase.setAndroidContext(this);
        //~ Enable disk persistence
        Firebase.getDefaultConfig().setPersistenceEnabled(true);
    }
}
