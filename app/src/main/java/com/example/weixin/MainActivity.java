package com.example.weixin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements View.OnClickListener {


    private ViewPager mvp;
    private FragmentPagerAdapter adapter;
    private List<Fragment> list;

    private LinearLayout mwx;
    private LinearLayout mpy;
    private LinearLayout mtxl;
    private LinearLayout msz;

    private ImageButton miwx;
    private ImageButton mipy;
    private ImageButton mitxl;
    private ImageButton misz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEnvn();
    }

    private void initEnvn() {
        mwx.setOnClickListener(this);
        mpy.setOnClickListener(this);
        mtxl.setOnClickListener(this);
        msz.setOnClickListener(this);
    }

    private void initView() {
        mvp = (ViewPager) findViewById(R.id.viewpager);
        mwx = (LinearLayout) findViewById(R.id.wx);
        mpy = (LinearLayout) findViewById(R.id.py);
        mtxl = (LinearLayout) findViewById(R.id.txl);
        msz = (LinearLayout) findViewById(R.id.sz);

        miwx = (ImageButton) findViewById(R.id.iwx);
        mipy = (ImageButton) findViewById(R.id.ipy);
        mitxl = (ImageButton) findViewById(R.id.itxl);
        misz = (ImageButton) findViewById(R.id.isz);

        list = new ArrayList<>();
        Fragment top01 = new weixin();
        Fragment top02 = new py();
        Fragment top03 = new txl();
        Fragment top04 = new sz();

        list.add(top01);
        list.add(top02);
        list.add(top03);
        list.add(top04);

        adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position)    {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        };
        mvp.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.wx:
                select(0);
                break;

            case R.id.py:
                select(1);
                break;

            case R.id.txl:
                select(2);
                break;

            case R.id.sz:
                select(3);
                break;
        }
    }

    public void select(int i) {
        switch (i) {
            case 0:
                mvp.setCurrentItem(0);

                break;

            case 1:
                mvp.setCurrentItem(1);
                break;

            case 2:
                mvp.setCurrentItem(2);
                break;

            case 3:
                mvp.setCurrentItem(3);
                break;
        }
    }
}
