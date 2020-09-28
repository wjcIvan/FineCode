package com.app.jieshu.mvp.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.app.jieshu.R;
import com.app.jieshu.mvp.main.fragment.F1;
import com.app.jieshu.mvp.main.fragment.F2;
import com.app.jieshu.mvp.main.fragment.F3;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv1, tv2, tv3;
    F1 f1;
    F2 f2;
    F3 f3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    protected void initView() {
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        selection(1);
    }

    /**
     * 点击不同的按钮做出不同的处理
     */
    private void selection(int index) {

        tv1.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.f11, 0, 0);
        tv1.setTextColor(getResources().getColor(R.color.huise));
        tv2.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.f33, 0, 0);
        tv2.setTextColor(getResources().getColor(R.color.huise));
        tv3.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.f22, 0, 0);
        tv3.setTextColor(getResources().getColor(R.color.huise));

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (fragments != null) {
            for (Fragment f : fragments) {
                ft.hide(f);
            }
        }

        Fragment fragment;
        switch (index) {
            case 1:
                tv1.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.f1, 0, 0);
                tv1.setTextColor(getResources().getColor(R.color.lvse));
                fragment = getSupportFragmentManager().findFragmentByTag("f1");
                if (fragment == null) {
                    f1 = new F1();
                    ft.add(R.id.frame, f1, "f1");
                } else {
                    ft.show(fragment);
                }
                break;

            case 2:
                tv2.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.f3, 0, 0);
                tv2.setTextColor(getResources().getColor(R.color.lvse));
                fragment = getSupportFragmentManager().findFragmentByTag("f2");
                if (fragment == null) {
                    f2 = new F2();
                    ft.add(R.id.frame, f2, "f2");
                } else {
                    ft.show(fragment);
                }
                break;
            case 3:

                tv3.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.f2, 0, 0);
                tv3.setTextColor(getResources().getColor(R.color.lvse));
                fragment = getSupportFragmentManager().findFragmentByTag("f3");
                if (fragment == null) {
                    f3 = new F3();
                    ft.add(R.id.frame, f3, "f3");
                } else {
                    ft.show(fragment);
                }
                break;
        }
        ft.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv3:
                selection(3);
                break;
            case R.id.tv2:
                selection(2);
                break;
            case R.id.tv1:
                selection(1);
                break;
        }
    }
}
