package cn.edu.szpt.mysimplemp3player;

import android.Manifest;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import cn.edu.szpt.mysimplemp3player.adapters.MusicListAdapter;
import cn.edu.szpt.mysimplemp3player.adapters.MyViewPagerAdapter;
import cn.edu.szpt.mysimplemp3player.beans.MusicBean;
import cn.edu.szpt.mysimplemp3player.services.PlayMusicService;
import cn.edu.szpt.mysimplemp3player.utils.SMPConstants;

public class MainActivity extends AppCompatActivity {
    private ViewPager pager;
    private PagerAdapter mAdapter;
    private StatusReceiver statusReceiver;

    private ArrayList<Fragment> fragments;

    //public static ArrayList<MusicBean> musicData;
    public static MusicListAdapter musicListAdapter;
    public static int currentIndex;
    //public static int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //musicsData=new ArrayList<MusicBean>();
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED) {
            //申请READ_EXTERNAL_STORAGE权限
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);
        }else{
        //    setData();
        }
        /*if(musicsData.size()>0)
            currentIndex=0;*/
        //musicListAdapter=new MusicListAdapter(getApplicationContext(),PlayMusicService.musicData);
        //currentIndex= intent.getIntExtra("index",-1);

        pager= (ViewPager) findViewById(R.id.pager);
        Intent intent=new Intent(MainActivity.this,PlayMusicService.class);

        intent.putExtra("CMD", SMPConstants.CMD_GETINFORM);

        startService(intent);

        /*fragments=new ArrayList<Fragment>();
        fragments.add(new MusicPlayFragment());
        fragments.add(new MusicListFragment());
        initViewPager();*/
    }

    /*public void setData(){
        musicsData.clear();
        Cursor c = this.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                new String[]{MediaStore.Audio.Media.TITLE,
                        MediaStore.Audio.Media.DURATION,
                        MediaStore.Audio.Media.ARTIST,
                        MediaStore.Audio.Media._ID,
                        MediaStore.Audio.Media.ALBUM_ID,
                        MediaStore.Audio.Media.DATA},
                null,null,null);

        while (c.moveToNext()){
            String musicname=c.getString(c.getColumnIndex(MediaStore.Audio.Media.TITLE));
            String singer=c.getString(c.getColumnIndex(MediaStore.Audio.Media.ARTIST));
            int duration=c.getInt(c.getColumnIndex(MediaStore.Audio.Media.DURATION));
            int albumid=c.getInt(c.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID));
            String musicurl=c.getString(c.getColumnIndex(MediaStore.Audio.Media.DATA));
            String lrcurl="";
            MusicBean bean=new MusicBean(musicname,singer,duration, albumid, musicurl, lrcurl);
            musicsData.add(bean);
        }
        c.close();
    }*/

    private void initViewPager(){
        mAdapter=new MyViewPagerAdapter(getSupportFragmentManager(),fragments);
        pager.setAdapter(mAdapter);
        pager.setCurrentItem(0);
    }

    class StatusReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            currentIndex=intent.getIntExtra("index",-1);
            int mpstatus=intent.getIntExtra("status",-1);
            //progress=intent.getIntExtra("PROGRESS",-1);

            //Log.i("gg","ggg");
            if(fragments == null){
                musicListAdapter=new MusicListAdapter(getApplicationContext(),PlayMusicService.musicsData);
                //Log.i("g","ggg");
                fragments=new ArrayList<Fragment>();
                MusicPlayFragment f1=new MusicPlayFragment();
                MusicListFragment f2=new MusicListFragment();
                fragments.add(f1);
                fragments.add(f2);
                initViewPager();
            }
            ((MusicPlayFragment)fragments.get(0)).setMpStatus(mpstatus);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Log.i("ggg","ggg");
        statusReceiver=new StatusReceiver();
        //Log.i("gggg","ggg");
        registerReceiver(statusReceiver,new IntentFilter(SMPConstants.ACT_SERVICE_REQUEST_BROADCAST));
    }
    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(statusReceiver);
    }
}
