package com.example.user.localservertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.localservertest.adapter.StudentAdapter;
import com.example.user.localservertest.data.Lecture;
import com.example.user.localservertest.data.User;
import com.example.user.localservertest.util.ServerUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class StudentListActivity extends BaseActivity {

    Lecture mLecture;

    ListView studentListView;
    List<User> students = new ArrayList<>();
    StudentAdapter mAdapter;

    Button findTeacherNameBtn;

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

        findTeacherNameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ServerUtil.getTeacherByLectureId(mContext, mLecture.getId(), new ServerUtil.JsonResponseHandler() {
                    @Override
                    public void onResponse(JSONObject json) {

                        try {
                            User teacher = User.getUserFromJson(json.getJSONObject("teacher"));


                            Toast.makeText(mContext, "담당 강사 : " + teacher.getName(), Toast.LENGTH_SHORT).show();
                            
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });
            }
        });

    }


    void getStudentFromServer() {
        ServerUtil.getStudentsById(mContext, mLecture.getId(), new ServerUtil.JsonResponseHandler() {
            @Override
            public void onResponse(JSONObject json) {


                try {
                    if (json.getBoolean("result")) {

                        students.clear();

                        JSONArray stds = json.getJSONArray("students");

                        for (int i =0; i < stds.length() ; i++) {
                            students.add(User.getUserFromJson(stds.getJSONObject(i)));
                        }

                        mAdapter.notifyDataSetChanged();

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    @Override
    public void setValues() {

        setTitle(mLecture.getName());

        mAdapter = new StudentAdapter(mContext, students);
        studentListView.setAdapter(mAdapter);

        getStudentFromServer();

    }

    @Override
    public void bindViews() {
        studentListView = findViewById(R.id.studentListView);
        findTeacherNameBtn = findViewById(R.id.findTeacherNameBtn);
    }
}
