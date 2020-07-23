package com.example.demo3.model;

import com.example.demo3.presenter.MyMessagePresenter;
import com.example.demo3.utils.HttpUtil;
import com.example.demo3.utils.LogUtil;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MyMessageModelImpl implements MyMessageModel {


    private String responseData;
    private MyMessagePresenter myMessagePresenter;

    public MyMessageModelImpl(MyMessagePresenter myMessagePresenter) {
        this.myMessagePresenter = myMessagePresenter;
    }

    @Override
    public void getResponseData(String adress) {

        HttpUtil.sendOkHttpRequest(adress, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                responseData = response.body().string();
                myMessagePresenter.jsonParse(responseData);
                LogUtil.d("MyMessagePresenter", responseData);
            }
        });

    }


}
