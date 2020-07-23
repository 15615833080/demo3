package com.example.demo3.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.demo3.view.LovelyFragment;
import com.example.demo3.view.PoliceFragment;

import static com.example.demo3.utils.Constant.L_NAME;
import static com.example.demo3.utils.Constant.P_NAME;
import static com.example.demo3.utils.Constant.WEB_SITE;

public class SlideSlidePagerAdapter extends FragmentPagerAdapter {

    public static final int INT = 2;
    public String adress;
    public Context mContext;
    public SlideSlidePagerAdapter(@NonNull FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position == 0)
            return new PoliceFragment(mContext,WEB_SITE + P_NAME);
        else
            return new LovelyFragment(mContext, WEB_SITE + L_NAME);
    }

    @Override
    public int getCount() {
        return INT;
    }
}
