/*
 * Created by 智捷课堂
 * 本书网站：http://www.51work6.com
 * 智捷课堂在线课堂：http://www.zhijieketang.com/
 * 智捷课堂微信公共号：zhijieketang
 * QQ：569418560 邮箱：eorient@sina.com
 * QQ交流群：162030268
 */

package com.example.audioplayer.ui;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.a51work6.myaudioplayer.R;
import com.example.audioplayer.ui.Util;

/**
 * Created by tonyguan on 2016/10/10.
 * 自定义游标适配器
 */

public class AudioCursorAdapter extends CursorAdapter {

    private int layout;

    private LayoutInflater inflater;

    public AudioCursorAdapter(Context context, int layout) {
        super(context, null, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        inflater = LayoutInflater.from(context);
        this.layout = layout;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        // 设置Title
        String title = cursor.getString(cursor
                .getColumnIndex(MediaStore.Audio.Media.TITLE));
        TextView titletview = (TextView) view.findViewById(R.id.title);
        titletview.setText(title);

        // 设置ARTIST
        String artist = cursor.getString(cursor
                .getColumnIndex(MediaStore.Audio.Media.ARTIST));
        TextView artistview = (TextView) view.findViewById(R.id.artist);
        artistview.setText("演唱者：" + artist);
        // 设置时间
        long duration = cursor.getLong(cursor
                .getColumnIndex(MediaStore.Audio.Media.DURATION));
        String time = Util.timeToString(duration);
        TextView durationview = (TextView) view.findViewById(R.id.duration);
        // 格式化时间
        durationview.setText("时长：" + time);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        final View view = inflater.inflate(layout, parent, false);
        return view;

    }
}
