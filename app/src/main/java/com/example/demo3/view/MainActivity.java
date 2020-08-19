package com.example.demo3.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Matrix;
import android.os.Bundle;

import com.example.demo3.R;
import com.example.demo3.adapter.SlideSlidePagerAdapter;
import com.example.demo3.utils.LogUtil;
import com.gigamole.navigationtabstrip.NavigationTabStrip;

public class MainActivity extends AppCompatActivity {

    private ViewPager mPager;
    SlideSlidePagerAdapter mPagerAdapter;
    private NavigationTabStrip mNavigationTabStrip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LogUtil.d("MyMessagePresenterImpl", "thread" + Thread.currentThread().getName());

        //findview
        mPager = findViewById(R.id.pager);
        mNavigationTabStrip = findViewById(R.id.nts_center);

        //init
        mPagerAdapter = new SlideSlidePagerAdapter(getSupportFragmentManager(),MainActivity.this);
        mPager.setAdapter(mPagerAdapter);
        mNavigationTabStrip.setViewPager(mPager,0);

    }

}
