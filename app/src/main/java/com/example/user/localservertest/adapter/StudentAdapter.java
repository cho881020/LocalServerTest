package com.example.user.localservertest.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.user.localservertest.R;
import com.example.user.localservertest.data.User;

import java.util.List;

/**
 * Created by user on 2017-11-17.
 */

public class StudentAdapter extends ArrayAdapter<User> {

    Context mContext;
    List<User> mList;
    LayoutInflater inf;

    public StudentAdapter(Context context, List<User> list) {
        super(context, R.layout.student_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = inf.inflate(R.layout.student_list_item, null);
        }

        User data = mList.get(position);

        TextView nameTxt = row.findViewById(R.id.nameTxt);
        nameTxt.setText(data.getName());

        return row;
    }
}









