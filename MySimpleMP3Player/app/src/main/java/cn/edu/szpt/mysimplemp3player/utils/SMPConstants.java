package cn.edu.szpt.mysimplemp3player.utils;

/**
 * Created by 龙心诚 on 2018/5/31 0031.
 */

public class SMPConstants {
    public static final int STATUS_STOP = 0;
    public static final int STATUS_PLAY = 1;
    public static final int STATUS_PAUSE = 2;
    public static final int STATUS_CALLIN_PAUSE = 3;

    public static final int CMD_PLAY = 1;     //播放
    public static final int CMD_PAUSE = 2;     //暂停
    public static final int CMD_CONTINUE = 3; //继续播放
    public static final int CMD_PREV = 4; //上一首
    public static final int CMD_NEXT = 5; //下一首
    public static final int CMD_GETINFORM = 6; //获取后台状态信息
    public static final int CMD_CHANDEPROGRESS = 7; //改变播放进度
    public static final int CMD_PLAYATPOSITION = 8; //播放指定位置歌曲

    public static final String ACT_SERVICE_REQUEST_BROADCAST="cn.edu.szpt.MySimpleMP3Player.ResponseInform";
    public static final String ACT_LRC_RETURN_BROADCAST="cn.edu.szpt.MySimpleMP3Player.ACT_LRC_RETURN_BROADCAST";
    public static final String ACT_PROGRESS_RETURN_BROADCAST="cn.edu.szpt.MySimpleMP3Player.ACT_PROGRESS_RETURN_BROADCAST";

}
