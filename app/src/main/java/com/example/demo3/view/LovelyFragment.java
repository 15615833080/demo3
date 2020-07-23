package com.example.demo3.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.demo3.R;
import com.example.demo3.base.BaseFragment;

public class LovelyFragment extends BaseFragment {
    private static final String TAG = "LovelyFragment";

    public LovelyFragment(Context context, String adress) {
        super(context, adress);
    }

   /* @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lovely, container, false);



        return view;
    }*/
}
