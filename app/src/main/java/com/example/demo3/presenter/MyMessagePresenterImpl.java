package com.example.demo3.presenter;

import android.app.Activity;
import android.os.Message;

import androidx.annotation.NonNull;

import com.example.demo3.bean.MyMessage;
import com.example.demo3.model.MyMessageModel;
import com.example.demo3.model.MyMessageModelImpl;
import com.example.demo3.utils.LogUtil;
import com.example.demo3.view.MyMessageView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;


public class MyMessagePresenterImpl extends Activity implements MyMessagePresenter {

    MyMessageView myMessageView;
    MyMessageModel myMessageModel;
    public List<MyMessage> myMessageList;
    public static final int SHOW = 1;
    MyHandler myHandler;
    public MyMessagePresenterImpl(MyMessageView myMessageView) {
        this.myMessageView = myMessageView;
        initMyMessageModel();
        myHandler = new MyHandler();
    }

    @Override
    public void initData(final String adress) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                myMessageList = new ArrayList<>();
                myMessageModel.getResponseData(adress);
                /*if(position == 0){
                    myMessageModel.getResponseData(WEB_SITE + P_NAME);
                }else {
                    myMessageModel.getResponseData(WEB_SITE + L_NAME);
                }*/
            }
        }).start();
    }


    @Override
    public void jsonParse(String responseData) {
        Gson gson = new Gson();
        myMessageList = gson.fromJson(responseData, new TypeToken<List<MyMessage>>(){}.getType());
        for(MyMessage message : myMessageList){
            LogUtil.d("MainActivity", message.toString());
        }
        Message msg = new Message();
        msg.what = SHOW;
        myHandler.sendMessage(msg);
    }

    private void initMyMessageModel() {
        myMessageModel = new MyMessageModelImpl(this);
    }


    class MyHandler extends android.os.Handler{

        @Override
        public void dispatchMessage(@NonNull Message msg) {
            super.dispatchMessage(msg);
                switch (msg.what){
                    case SHOW:
                        myMessageView.showMessage(myMessageList);
                        break;
                }
        }
    }

}
