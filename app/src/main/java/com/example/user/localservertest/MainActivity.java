package com.example.user.localservertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.localservertest.adapter.LectureAdapter;
import com.example.user.localservertest.data.Lecture;
import com.example.user.localservertest.util.ServerUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private ListView lectureListView;
    List<Lecture> lectureList = new ArrayList<>();
    LectureAdapter mAdapter;


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

        mAdapter = new LectureAdapter(mContext, lectureList);
        lectureListView.setAdapter(mAdapter);

        getLecturesFromServer();

    }

    private void getLecturesFromServer() {
        ServerUtil.getAllLectures(mContext, new ServerUtil.JsonResponseHandler() {
            @Override
            public void onResponse(JSONObject json) {
                try {
                    boolean result = json.getBoolean("result");

                    if (result) {
//                        Toast.makeText(mContext, "성공입니다.", Toast.LENGTH_SHORT).show();

                        lectureList.clear();

                        JSONArray lectures = json.getJSONArray("lectures");
                        for (int i=0 ; i < lectures.length() ; i++) {
                            Lecture l = Lecture.getLectureFromJson(lectures.getJSONObject(i));
                            lectureList.add(l);
                        }

                        mAdapter.notifyDataSetChanged();

                    }
                    else {
                        Toast.makeText(mContext, "강의목록을 가져오는데 실패했습니다.", Toast.LENGTH_SHORT).show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void bindViews() {
        lectureListView = findViewById(R.id.lectureListView);
    }
}
