package com.example.user.localservertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.user.localservertest.util.ServerUtil;

import org.json.JSONObject;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {

        ServerUtil.test(mContext, new ServerUtil.JsonResponseHandler() {
            @Override
            public void onResponse(JSONObject json) {

            }
        });

    }

    @Override
    public void bindViews() {

    }
}
