package wjc.ivan.oschina.activity;

import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import wjc.ivan.oschina.services.FloatingService;
import wjc.ivan.oschina.utils.BottomBar;
import wjc.ivan.oschina.R;
import wjc.ivan.oschina.fragment.AdminFragment;
import wjc.ivan.oschina.fragment.BlogFragment;
import wjc.ivan.oschina.fragment.SynthesisFragment;

public class BigActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big);
        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        if (name!=null) {
            Log.i("name", name);
            AdminFragment.Name=name;
        }
        //Intent intent1 = new Intent(BigActivity.this,FloatingService.class);
        //startService(new Intent(this,FloatingService.class));
        startFloatingService();
        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottom_bar);
        bottomBar.setContainer(R.id.fl_container)
                .setTitleBeforeAndAfterColor("#999999", "#ff5d5e")
                .addItem(SynthesisFragment.class,
                        "综合",
                        R.drawable.item1_before,
                        R.drawable.item1_after)
                .addItem(BlogFragment.class,
                        "博客",
                        R.drawable.item2_before,
                        R.drawable.item2_after)
                .addItem(AdminFragment.class,
                        "我的",
                        R.drawable.item3_before,
                        R.drawable.item3_after)
                .build();
    }
    public void startFloatingService() {
        if (!Settings.canDrawOverlays(this)) {
            Toast.makeText(this, "当前无权限，请授权", Toast.LENGTH_SHORT);
            startActivityForResult(new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getPackageName())), 0);
        } else {
            startService(new Intent(BigActivity.this, FloatingService.class));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0) {
            if (!Settings.canDrawOverlays(this)) {
                Toast.makeText(this, "授权失败", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "授权成功", Toast.LENGTH_SHORT).show();
                startService(new Intent(BigActivity.this, FloatingService.class));
            }
        }
    }
}
