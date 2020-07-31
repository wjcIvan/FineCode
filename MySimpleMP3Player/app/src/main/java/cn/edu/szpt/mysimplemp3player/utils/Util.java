package cn.edu.szpt.mysimplemp3player.utils;

/**
 * Created by 龙心诚 on 2018/5/30 0030.
 */

public class Util {
    public static String toTime(int time){
        time/=1000;
        int minute =time/60;
        int hour =minute/60;
        int second =time%60;
        minute %=60;
        if (hour>0){
            return String.format("%02d:%02d:%02d",hour,minute,second);
        }else
            return String.format("%02d:%02d",minute,second);
    }
}
