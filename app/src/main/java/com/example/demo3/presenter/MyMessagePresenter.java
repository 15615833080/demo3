package com.example.demo3.presenter;

import com.example.demo3.adapter.RecyclerAdapter;

import io.reactivex.disposables.Disposable;

public interface MyMessagePresenter {

    public void initData(String adress);
    public void jsonParse(String responseData);
    public void getData(String mAdress, RecyclerAdapter recyclerAdapter, Disposable disposable);
}
