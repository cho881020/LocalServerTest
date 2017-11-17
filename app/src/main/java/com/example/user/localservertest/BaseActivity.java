package com.example.user.localservertest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by user on 2017-11-17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    Context mContext = this;

    public abstract void setupEvents();
    public abstract void setValues();
    public abstract void bindViews();

}
