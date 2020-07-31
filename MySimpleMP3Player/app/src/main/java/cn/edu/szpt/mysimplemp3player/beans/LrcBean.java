package cn.edu.szpt.mysimplemp3player.beans;

import android.support.annotation.NonNull;

/**
 * Created by 龙心诚 on 2018/6/14 0014.
 */

public class LrcBean implements Comparable<LrcBean> {
    private int beginTime;
    private String lrcmMsg;

    public int getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(int beginTime) {
        this.beginTime = beginTime;
    }

    public String getLrcmMsg() {
        return lrcmMsg;
    }

    public void setLrcmMsg(String lrcmMsg) {
        this.lrcmMsg = lrcmMsg;
    }

    public LrcBean(int beginTime, String lrcmMsg) {

        this.beginTime = beginTime;
        this.lrcmMsg = lrcmMsg;
    }

    @Override
    public int compareTo(@NonNull LrcBean another) {
        return this.beginTime-another.beginTime;
    }
}
