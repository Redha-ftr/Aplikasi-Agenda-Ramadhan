package com.redha.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class CustomCursorAdapter extends CursorAdapter {
private LayoutInflater ly;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public CustomCursorAdapter(Context context,Cursor c, int flags){
        super(context, c, flags);
        ly = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View v = ly.inflate(R.layout.activity_list_adapter,viewGroup,false);
        MyHolder holder = new MyHolder();
        holder.no = (TextView) v.findViewById(R.id.no);
        holder.progress = (TextView) v.findViewById(R.id.progres);
        v.setTag(holder);
        return v;
    }

    @SuppressLint("Range")
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        MyHolder holder = (MyHolder) view.getTag();

        holder.no.setText(cursor.getString(cursor.getColumnIndex((DBHandler.row_id))));
        holder.progress.setText("Progress : "+cursor.getString(cursor.getColumnIndex(DBHandler.progress))+"%");
    }

    class MyHolder{
        TextView no, progress;
    }
}