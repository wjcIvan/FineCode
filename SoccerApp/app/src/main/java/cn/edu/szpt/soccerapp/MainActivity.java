package cn.edu.szpt.soccerapp;




import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView tv1;
    private ListView lv1;
    private TeamAdapter adapter;
    private List<TeamBean> list;
    private LruCache<String,Bitmap> cache;
    //private TeamBean teamBean;
    /*private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==1)
                tv1.setText(msg.obj.toString());
        }
    };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1= (TextView) findViewById(R.id.tv1);
        lv1= (ListView) findViewById(R.id.lv1);
        lv1.setEmptyView(tv1);
        list=new ArrayList<TeamBean>();
        int maxMemory= (int) Runtime.getRuntime().totalMemory();
        int cacheSize=maxMemory/8;
        cache=new LruCache<String ,Bitmap>(cacheSize){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes()*value.getHeight()/1024;
            }
        };
        adapter=new TeamAdapter(list,this,cache);
        lv1.setAdapter(adapter);
        new StrGetTask(adapter,list).execute("http://10.1.102.44/soccerdatahandler.ashx?action=getTeamWithFlagList");
        //tv1.setOnClickListener();
    }

    /*class GetHttpUrl implements Runnable{

        @Override
        public void run() {
            try {
                HttpURLConnection con= (HttpURLConnection) new URL("http://10.1.102.44/soccerdatahandler.ashx?action=getTeamStr").openConnection();
                int code=con.getResponseCode();
                if(code==HttpURLConnection.HTTP_OK){
                    InputStream is=con.getInputStream();
                    ByteArrayOutputStream baos=new ByteArrayOutputStream();
                    int n=0;
                    byte[] buf=new byte[1024];

                    while((n=is.read(buf))!=-1){
                        baos.write(buf,0,n);
                    }
                    String str=baos.toString("UTF-8");
                    Message msg=new Message();
                    msg.what=1;
                    msg.obj=str;
                    tv1.setText(str);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/

}
