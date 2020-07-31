package cn.edu.szpt.mysimplemp3player.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.edu.szpt.mysimplemp3player.MainActivity;
import cn.edu.szpt.mysimplemp3player.R;
import cn.edu.szpt.mysimplemp3player.beans.MusicBean;
import cn.edu.szpt.mysimplemp3player.utils.Util;

/**
 * Created by 龙心诚 on 2018/5/30 0030.
 */

public class MusicListAdapter extends BaseAdapter {
    private Context context;
    List<MusicBean> data;

    public MusicListAdapter(Context context, List<MusicBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_music,parent,false);
            holder=new ViewHolder();
            holder.item_imgShowPic= (ImageView) convertView.findViewById(R.id.item_imgShowPic);
            holder.item_tvMusicName= (TextView) convertView.findViewById(R.id.item_tvMusicName);
            holder.item_tvMusicSinger= (TextView) convertView.findViewById(R.id.item_tvMusicSinger);
            holder.item_tvMusicDuration= (TextView) convertView.findViewById(R.id.item_tvMusicDuration);
            convertView.setTag(holder);
        }else
            holder = (ViewHolder) convertView.getTag();

        MusicBean musicBean=data.get(position);
        holder.item_imgShowPic.setImageResource(R.drawable.item);
        holder.item_tvMusicName.setText(musicBean.getMusicName());
        holder.item_tvMusicSinger.setText(musicBean.getSinger());
        holder.item_tvMusicDuration.setText(Util.toTime(musicBean.getMusicDuration()));
        if (position==MainActivity.currentIndex){
            holder.item_imgShowPic.setImageResource(R.drawable.isplaying);
            convertView.setBackgroundColor(Color.RED);
        }else
            convertView.setBackgroundColor(Color.TRANSPARENT);
        return convertView;
    }

    public void refreshSelectPosition(){
        notifyDataSetChanged();
    }

    static class ViewHolder{
        ImageView item_imgShowPic;
        TextView item_tvMusicName;
        TextView item_tvMusicSinger;
        TextView item_tvMusicDuration;
    }
}
