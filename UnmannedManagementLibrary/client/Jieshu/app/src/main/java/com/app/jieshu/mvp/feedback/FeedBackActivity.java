package com.app.jieshu.mvp.feedback;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.app.jieshu.R;
import com.app.jieshu.util.T;

public class FeedBackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);
        findViewById(R.id.layout_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.tvBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                T.show("反馈成功");
                finish();
            }
        });
    }
}
