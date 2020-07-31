package cn.edu.szpt.mysimplemp3player;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import cn.edu.szpt.mysimplemp3player.beans.MusicBean;
import cn.edu.szpt.mysimplemp3player.services.PlayMusicService;
import cn.edu.szpt.mysimplemp3player.utils.SMPConstants;
import cn.edu.szpt.mysimplemp3player.utils.Util;

/**
 * Created by Fly on 2018/5/29.
 */

public class MusicPlayFragment extends Fragment implements View.OnClickListener{
    private ImageView btnPlay;
    private ImageView btnPrev;
    private ImageView btnNext;
    private TextView tvMusicName;
    private TextView tvDuration;
    private TextView tvLrc;
    private TextView tvPlayTime;
    private SeekBar sbMusic;
    private ImageView imgShowPic;
    //private MediaPlayer mp;
    private int MpStatus;
    private LrcReceive lrcReceive;
    private PrgReceive prgReceive;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_music,container,false);

        tvMusicName= (TextView) view.findViewById(R.id.tvMusicName);
        tvPlayTime= (TextView) view.findViewById(R.id.tvPlayTime);
        tvDuration= (TextView) view.findViewById(R.id.tvDuration);
        tvLrc= (TextView) view.findViewById(R.id.tvLrc);
        sbMusic= (SeekBar) view.findViewById(R.id.sbMusic);
        imgShowPic= (ImageView) view.findViewById(R.id.imgShowPic);
        btnNext= (ImageView) view.findViewById(R.id.btnNext);
        btnPrev= (ImageView) view.findViewById(R.id.btnPrev);
        btnPlay= (ImageView) view.findViewById(R.id.btnPlay);
        initView(MainActivity.currentIndex);

        //当前播放器状态设置为Stop状态
        MpStatus= SMPConstants.STATUS_STOP;
        //Log.i("F**k it",MpStatus+"");
        btnPlay.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnPrev.setOnClickListener(this);

        sbMusic.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                /*Intent i = new Intent(getActivity(),PlayMusicService.class);
                i.putExtra("CMD",SMPConstants.CMD_CHANDEPROGRESS);
                i.putExtra("PROGRESS",progress);
                getActivity().startService(i);*/
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
//                pauseMusic();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Intent i = new Intent(getActivity(),PlayMusicService.class);
                int progress=seekBar.getProgress();
                i.putExtra("CMD",SMPConstants.CMD_CHANDEPROGRESS);
                i.putExtra("PROGRESS",progress);
                getActivity().startService(i);
            }
        });



        // 实例化MediaPlayer对象
        //mp = new MediaPlayer();

        /*mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                nextMusic();
            }
        });*/
        lrcReceive=new LrcReceive();
        getActivity().registerReceiver(lrcReceive,new IntentFilter(SMPConstants.ACT_LRC_RETURN_BROADCAST));
        prgReceive = new PrgReceive();
        getActivity().registerReceiver(prgReceive,new IntentFilter(SMPConstants.ACT_PROGRESS_RETURN_BROADCAST));
        return view;
    }
    class LrcReceive extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            String msg=intent.getStringExtra("LRC");
            tvLrc.setText(msg);
        }

    }

    class PrgReceive extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            int time=intent.getIntExtra("PROGRESS",0);
            sbMusic.setProgress(time);
            tvPlayTime.setText(Util.toTime(time));
            //Log.i("TimeWrong1",time+"");
            //Log.i("TimeWrong",Util.toTime(time));
        }

    }
    /*class ChangePlayReceive extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            int position=intent.getIntExtra("INDEX",0);
        }
    }*/

    private String getAlbumArt(int album_id){
        String mUriAlbums= "content://media/external/audio/albums";
        String[] projection =new String[]{"album_art"};
        Cursor cursor=this.getActivity().getApplicationContext().getContentResolver().query(Uri.parse(mUriAlbums+"/"+Integer.toString(album_id)),projection,null,null,null);
        String album_art=null;
        if(cursor.getCount()>0 && cursor.getColumnCount()>0){
            cursor.moveToNext();
            album_art=cursor.getString(0);
        }
        cursor.close();
        cursor=null;
        return album_art;
    }
    private void initView(int music_index){
        if(music_index>-1){
            MusicBean bean=PlayMusicService.musicsData.get(music_index);
            tvMusicName.setText(bean.getMusicName());
            tvPlayTime.setText("0:0"); tvDuration.setText(Util.toTime(bean.getMusicDuration()));
            tvLrc.setText("");

            //设置进度条的最大长度
            sbMusic.setIndeterminate(false);
            sbMusic.setMax(bean.getMusicDuration());

            // 获取专辑id
            int album_id=bean.getAlbum_id();
            Bitmap bm = null;

            // 获取专辑图片路径
            String albumArt = getAlbumArt(album_id);

            if (albumArt != null){
                try {
                    bm= BitmapFactory.decodeFile(albumArt);
                } catch (Exception e) {
                    Log.i("Err","打开专辑封面出错");
                }
                if(bm != null){
                    BitmapDrawable bitmapDrawable =new BitmapDrawable(getResources(),bm);
                    imgShowPic.setImageDrawable(bitmapDrawable);
                }else
                    imgShowPic.setImageResource(R.drawable.nopic);
            }else
                imgShowPic.setImageResource(R.drawable.nopic);
        }

    }
    private void pauseMusic(){
        //mp.pause();
        Intent i = new Intent(getActivity(),PlayMusicService.class);
        i.putExtra("CMD",SMPConstants.CMD_PAUSE);
        getActivity().startService(i);

        MpStatus=SMPConstants.STATUS_PAUSE;
        btnPlay.setImageResource(R.drawable.play_selector);
    }

    private void continueMusic(){
        //mp.start();
        Intent i = new Intent(getActivity(),PlayMusicService.class);
        i.putExtra("CMD",SMPConstants.CMD_CONTINUE);
        getActivity().startService(i);
        MpStatus=SMPConstants.STATUS_PLAY;
        btnPlay.setImageResource(R.drawable.pause_selector);
    }

    private void playMusic(){
       /* String musicPath= PlayMusicService.musicData.get(MainActivity.currentIndex).getMusicUrl();

        try {
            *//*mp.reset();
            mp.setDataSource(musicPath);
            mp.prepare();
            mp.start();*//*
            MpStatus=SMPConstants.STATUS_PLAY;
            btnPlay.setImageResource(R.drawable.pause_selector);
            tvLrc.setText("");
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        Intent i = new Intent(getActivity(),PlayMusicService.class);
        i.putExtra("CMD",SMPConstants.CMD_PLAY);
        getActivity().startService(i);
        MpStatus=SMPConstants.STATUS_PLAY;
        btnPlay.setImageResource(R.drawable.pause_selector);
        tvLrc.setText("");
    }

    private void prevMusic(){
        Intent i = new Intent(getActivity(),PlayMusicService.class);
        i.putExtra("CMD",SMPConstants.CMD_PREV);
        getActivity().startService(i);
        if(MainActivity.currentIndex<=0){
            MainActivity.currentIndex=PlayMusicService.musicsData.size()-1;
        }else
            MainActivity.currentIndex--;
        playMusic();
        MpStatus=SMPConstants.STATUS_PLAY;
        tvLrc.setText("");
        btnPlay.setImageResource(R.drawable.pause_selector);
        initView(MainActivity.currentIndex);
    }

    private void nextMusic(){
        Intent i = new Intent(getActivity(),PlayMusicService.class);
        i.putExtra("CMD",SMPConstants.CMD_NEXT);
        getActivity().startService(i);
        if(MainActivity.currentIndex >= PlayMusicService.musicsData.size()-1){
            MainActivity.currentIndex=0;
        }else
            MainActivity.currentIndex++;
        //playMusic();
        MpStatus=SMPConstants.STATUS_PLAY;
        btnPlay.setImageResource(R.drawable.pause_selector);
        initView(MainActivity.currentIndex);
    }

    @Override
    public void onClick(View v) {
        //Log.i("WrongIdTest",MpStatus+"");
        switch (v.getId()){
            case R.id.btnPlay:
                switch (MpStatus) {
                    case SMPConstants.STATUS_PAUSE: continueMusic();
                        break;
                    case SMPConstants.STATUS_PLAY: pauseMusic();
                        break;
                    case SMPConstants.STATUS_STOP: playMusic();
                        break;
                    default:
                        break;
                }
                break;
            case R.id.btnPrev: prevMusic();
                break;
            case R.id.btnNext: nextMusic();
                break;
            default:
                break;
        }
        MainActivity.musicListAdapter.refreshSelectPosition();
    }

    public void setMpStatus(int mpStatus){
        initView(MainActivity.currentIndex);
        MpStatus=mpStatus;
        /*if(MainActivity.progress>0){
            sbMusic.setProgress(MainActivity.progress);
        }*/
        if(mpStatus==SMPConstants.STATUS_PLAY){
            btnPlay.setImageResource(R.drawable.pause_selector);
        }else{
            btnPlay.setImageResource(R.drawable.play_selector);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        getActivity().unregisterReceiver(lrcReceive);
        getActivity().unregisterReceiver(prgReceive);
    }
}
