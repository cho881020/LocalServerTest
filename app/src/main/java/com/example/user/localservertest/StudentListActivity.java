package com.example.user.localservertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user.localservertest.data.Lecture;

public class StudentListActivity extends BaseActivity {

    Lecture mLecture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        mLecture = (Lecture) getIntent().getSerializableExtra("lecture");
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {

        setTitle(mLecture.getName());

    }

    @Override
    public void bindViews() {

    }
}
