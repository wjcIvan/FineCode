package wjc.ivan.oschina.application;

import android.app.Application;

import com.itheima.retrofitutils.ItheimaHttp;

/**
 * Created by 龙心诚 on 2018/6/25 0025.
 */

public class OsChinaApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ItheimaHttp.init(this, "http://www.oschina.net/");
    }
}
