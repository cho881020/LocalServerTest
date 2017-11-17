package com.example.user.localservertest.data;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by user on 2017-11-17.
 */

public class Lecture implements Serializable {


    private int id;
    private String name;
    private String start_date;
    private String end_date;
    private String open_time;
    private String close_time;

    public static Lecture getLectureFromJson(JSONObject jsonObject) {

        Lecture lecture = new Lecture();

        try {
            lecture.id = jsonObject.getInt("id");
            lecture.name = jsonObject.getString("name");
            lecture.start_date = jsonObject.getString("start_date");
            lecture.end_date = jsonObject.getString("end_date");
            lecture.open_time = jsonObject.getString("open_time");
            lecture.close_time = jsonObject.getString("close_time");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return lecture;
    }

    public Lecture() {
    }

    public Lecture(int id, String name, String start_date, String end_date, String open_time, String close_time) {
        this.id = id;
        this.name = name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.open_time = open_time;
        this.close_time = close_time;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getStart_date() {
        return start_date;
    }
    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }
    public String getEnd_date() {
        return end_date;
    }
    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }
    public String getOpen_time() {
        return open_time;
    }
    public void setOpen_time(String open_time) {
        this.open_time = open_time;
    }
    public String getClose_time() {
        return close_time;
    }
    public void setClose_time(String close_time) {
        this.close_time = close_time;
    }



}
