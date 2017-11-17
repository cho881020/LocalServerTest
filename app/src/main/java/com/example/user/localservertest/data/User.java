package com.example.user.localservertest.data;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by user on 2017-11-17.
 */

public class User implements Serializable {


    private int id;
    private String name;
    private String birthday;
    private int gender;
    private String address;
    private String phone;
    private String profile_url;
    private int height;

    public static User getUserFromJson(JSONObject jsonObject) {
        User u = new User();

        try {
            u.id = jsonObject.getInt("id");
            u.name = jsonObject.getString("name");
            u.gender = jsonObject.getInt("gender");
            u.address = jsonObject.getString("address");
            u.phone = jsonObject.getString("phone");
            if (!jsonObject.isNull("profile_url")) {
                u.profile_url = jsonObject.getString("profile_url");
            }
            u.height = jsonObject.getInt("height");
            u.birthday = jsonObject.getString("birthDay");

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return u;
    }

    public User() {
    }

    public User(int id, String name, String birthday, int gender, String address, String phone, String profile_url, int height) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.profile_url = profile_url;
        this.height = height;
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
    public String getBirthDay() {
        return birthday;
    }
    public void setBirthDay(String birthDay) {
        this.birthday = birthDay;
    }
    public int getGender() {
        return gender;
    }
    public void setGender(int gender) {
        this.gender = gender;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getProfile_url() {
        return profile_url;
    }
    public void setProfile_url(String profile_url) {
        this.profile_url = profile_url;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }



}
