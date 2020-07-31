package cn.edu.szpt.mysimplemp3player.services;

import android.app.Service;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.IBinder;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ProgressBar;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import cn.edu.szpt.mysimplemp3player.beans.LrcBean;
import cn.edu.szpt.mysimplemp3player.beans.MusicBean;
import cn.edu.szpt.mysimplemp3player.lrc.LrcProcessor;
import cn.edu.szpt.mysimplemp3player.utils.SMPConstants;

/**
 * Created by Fly on 2018/6/1.
 */

public class PlayMusicService extends Service {
    public  static ArrayList<MusicBean> musicsData;
    private int currentIndex=-1;

    private MediaPlayer mp;
    private int MpStatus;

    private ArrayList<LrcBean> lrcs;
    private int nextTimeMil=0;
    private int LrcPos;
    private String message;
    private Handler lrcHandler =new Handler();
    private LrcCallBack r =null;

    private Handler prgHandler=new Handler();
    private PrgCallBack pr=null;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        musicsData=new ArrayList<MusicBean>();
        setData();
        if(musicsData.size()>0) currentIndex=0;
        MpStatus=SMPConstants.STATUS_STOP;
        mp=new MediaPlayer();
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                nextMusic();
                sendPMSInform();
            }
        });

    }



    private void setData() {

        musicsData.clear();

        Cursor cursor=this.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,new String[]{MediaStore.Audio.Media.TITLE, MediaStore.Audio.Media.DURATION, MediaStore.Audio.Media.ARTIST, MediaStore.Audio.Media._ID, MediaStore.Audio.Media.ALBUM_ID, MediaStore.Audio.Media.DATA},null,null,null);
        while (cursor.moveToNext()){
            String musicName=cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
            String singer=cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
            int duration=cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION));
            int albumid=cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID));
            String musicurl=cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
            String lrcurl="";
            MusicBean bean=new MusicBean(musicName,singer,duration,albumid,musicurl,lrcurl);
            musicsData.add(bean);
        }
        cursor.close();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(intent != null) {
            int cmd = intent.getIntExtra("CMD", -1);
            //Log.i("WrongTest2",cmd+"");
            switch (cmd) {
                case SMPConstants.CMD_GETINFORM:
                    sendPMSInform();
                    break;
                case SMPConstants.CMD_PLAY:
                    playMusic();
                    break;
                case SMPConstants.CMD_NEXT:
                    nextMusic();
                    break;
                case SMPConstants.CMD_PAUSE:
                    pauseMusic();
                    break;
                case SMPConstants.CMD_CONTINUE:
                    continueMusic();
                    break;
                case SMPConstants.CMD_PREV:
                    prevMusic();
                    break;
                case SMPConstants.CMD_CHANDEPROGRESS:
                    int progress=intent.getIntExtra("PROGRESS",-1);
                    changeLrc(progress);
                    break;
                case SMPConstants.CMD_PLAYATPOSITION:
                    int position=intent.getIntExtra("index",-1);
                    changePlay(position);
                    break;
            }
        }
        return super.onStartCommand(intent, flags, startId);

    }

    private void changePlay(int position) {
        String musicPath =musicsData.get(position).getMusicUrl();
        try {
            mp.reset();
            mp.setDataSource(musicPath);
            mp.prepare();
            initLrc(musicPath.substring(0,musicPath.length()-3)+"lrc");
            lrcHandler.post(r);
            prgHandler.post(pr);
            mp.start();
            MpStatus=SMPConstants.STATUS_PLAY;

        } catch (Exception e) {
            e.printStackTrace();
        }
        Intent intent = new Intent(SMPConstants.ACT_SERVICE_REQUEST_BROADCAST);
        intent.putExtra("index",position);
        //intent.putExtra("PROGRESS",mp.getDuration());
        intent.putExtra("status",MpStatus);
        sendBroadcast(intent);

    }
/*    private void changeProgress(int progress){
//        String musicPath =musicsData.get(currentIndex).getMusicUrl();
//        //mp.reset();
//        try {
//            mp.setDataSource(musicPath);
//            mp.prepare();
//            MpStatus=SMPConstants.STATUS_PLAY;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        changeLrc(progress);
    }*/

    private void changeLrc(int progress){
        mp.seekTo(progress);
        if(lrcs == null || lrcs.size()==0) return;
        LrcPos=0;
        for (LrcBean temBean:lrcs){
            if (temBean.getBeginTime()>=progress)break;
        }

        for(int i = 0;i<lrcs.size();i++){
            nextTimeMil=lrcs.get(LrcPos).getBeginTime();
            message=lrcs.get(LrcPos).getLrcmMsg();
            if(progress>=nextTimeMil){
                Intent intent = new Intent(SMPConstants.ACT_LRC_RETURN_BROADCAST);
                intent.putExtra("LRC",message);
                sendBroadcast(intent);
                LrcPos++;
            }
        }
    }


    private void pauseMusic() {
        mp.pause();
        MpStatus=SMPConstants.STATUS_PAUSE;
    }

    private void playMusic() {
        String musicPath =musicsData.get(currentIndex).getMusicUrl();
        try {
            mp.reset();
            mp.setDataSource(musicPath);
            mp.prepare();
            initLrc(musicPath.substring(0,musicPath.length()-3)+"lrc");
            lrcHandler.post(r);
            prgHandler.post(pr);
            mp.start();
            MpStatus=SMPConstants.STATUS_PLAY;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void continueMusic(){
        mp.start();
        MpStatus=SMPConstants.STATUS_PLAY;
    }
    private void prevMusic(){
        if (currentIndex<=0){
            currentIndex=musicsData.size()-1;
        }else currentIndex--;
        playMusic();
        MpStatus=SMPConstants.STATUS_PLAY;
    }
    private void nextMusic() {
        if(currentIndex>=musicsData.size()-1){
            currentIndex=0;
        }else currentIndex++;
        playMusic();
        MpStatus=SMPConstants.STATUS_PLAY;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void sendPMSInform(){
        Intent intent = new Intent(SMPConstants.ACT_SERVICE_REQUEST_BROADCAST);
        intent.putExtra("index",currentIndex);
        //intent.putExtra("PROGRESS",mp.getDuration());
        intent.putExtra("status",MpStatus);
        sendBroadcast(intent);
    }

    private void initLrc(String lrcPath){
        InputStream in;
        try {
            String charset= LrcProcessor.getCharSet(new FileInputStream(lrcPath));
            LrcProcessor lrcProcessor=new LrcProcessor();
            in = new FileInputStream(lrcPath);
            lrcs=lrcProcessor.process(in,charset);
            if (r!=null){
                lrcHandler.removeCallbacks(r);
            }
            r=new LrcCallBack(lrcs);
            if (pr!=null) prgHandler.removeCallbacks(pr);
            pr=new PrgCallBack();

            nextTimeMil=0;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    class LrcCallBack implements Runnable{
        private ArrayList<LrcBean> lrcList;
        public LrcCallBack(ArrayList<LrcBean> lrcList) {
            this.lrcList = lrcList;
            LrcPos = 0;
        }

        @Override
        public void run() {
            try {
                if (nextTimeMil==0){
                    nextTimeMil = lrcList.get(LrcPos).getBeginTime();
                    message=lrcList.get(LrcPos).getLrcmMsg();
                }
                int time=mp.getCurrentPosition();
                if(time>=nextTimeMil){
                    Intent i = new Intent(SMPConstants.ACT_LRC_RETURN_BROADCAST);
                    i.putExtra("LRC",message);
                    sendBroadcast(i);
                    LrcPos++;
                    nextTimeMil=lrcList.get(LrcPos).getBeginTime();
                    message=lrcList.get(LrcPos).getLrcmMsg();
                }
                if (time<mp.getDuration()){
                    lrcHandler.postDelayed(this,10);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class PrgCallBack implements Runnable{
        @Override
        public void run() {
            int time=mp.getCurrentPosition();
            Intent i=new Intent(SMPConstants.ACT_PROGRESS_RETURN_BROADCAST);
            i.putExtra("PROGRESS",time);
            sendBroadcast(i);
            prgHandler.postDelayed(this,300);
        }
    }


}
