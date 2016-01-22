package com.jarvis.service;

/**
 * Created by arungu on 1/17/2016.
 */

public class Context {
    private Context() {}   //for Singleton behavior

    private static final Context context = new Context();

    public static Context getInstance() {
        return context;
    }

}
