package com.app.jieshu.mvp.main.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.jieshu.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/3/16
 */
public class F2 extends Fragment {
    View view;
    String[] strings = {"待归还", "已归还"};
    TabLayout tab;
    ViewPager pager;
    public List<F2_item> fragments;
    FragmentManager fm;
    MyAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.f2, container, false);
        tab = (TabLayout) view.findViewById(R.id.tab);
        pager = (ViewPager) view.findViewById(R.id.pager);
        fragments = new ArrayList<>();
        fragments.add(F2_item.getInstence(0));
        fragments.add(F2_item.getInstence(1));
        fm = getFragmentManager();
        adapter = new MyAdapter(getChildFragmentManager());
        pager.setAdapter(adapter);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {


            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        tab.setTabMode(TabLayout.MODE_FIXED);
        tab.setupWithViewPager(pager);

        return view;
    }

    public void updateUi() {
        //setFragments(fragments);
        for (int i = 0; i < fragments.size(); i++) {
            if (fragments.get(i) != null) {
                fragments.get(i).onResume();
            }

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    public void setFragments(List fragments) {
        if (fragments != null && fm != null) {
            FragmentTransaction ft = fm.beginTransaction();
            for (Fragment f : this.fragments) {
                ft.remove(f);
            }
            ft.commit();
            fm.executePendingTransactions();
        }
        this.fragments = fragments;
        adapter.notifyDataSetChanged();
    }

    private class MyAdapter extends FragmentStatePagerAdapter {

        @Override
        public int getItemPosition(@NonNull Object object) {
            return POSITION_NONE;
        }

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return strings[position];

        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
        }
    }
}
