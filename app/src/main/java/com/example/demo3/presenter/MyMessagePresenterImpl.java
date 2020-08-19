package com.example.demo3.presenter;

import android.app.Activity;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.demo3.adapter.RecyclerAdapter;
import com.example.demo3.bean.MyMessage;
import com.example.demo3.model.MyMessageModel;
import com.example.demo3.model.MyMessageModelImpl;
import com.example.demo3.network.NetWork;
import com.example.demo3.utils.LogUtil;
import com.example.demo3.view.MyMessageView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static com.example.demo3.utils.Constant.P_NAME;


public class MyMessagePresenterImpl extends Activity implements MyMessagePresenter {

    MyMessageView myMessageView;
    MyMessageModel myMessageModel;
    public List<MyMessage> myMessageList;
    public static final int SHOW = 1;
    //子线程中发出handler，由主线程接受
    MyHandler myHandler;
    public MyMessagePresenterImpl(MyMessageView myMessageView) {
        this.myMessageView = myMessageView;
        initMyMessageModel();
        myHandler = new MyHandler();
    }


    @Override
    public void getData(String mAdress, RecyclerAdapter recyclerAdapter, Disposable disposable) {
        NetWork instance = NetWork.getInstance();
        disposable = instance.getMessageData()
                .search(mAdress)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<MyMessage>>() {
                    @Override
                    public void accept(List<MyMessage> myMessages) throws Exception {
                        recyclerAdapter.setMessages(myMessages);
                        LogUtil.d("MyMessagePresenterImpl", "myMessages: + thread" + myMessages + Thread.currentThread().getName());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        LogUtil.d("MyMessagePresenterImpl", "myMessages: false");
                    }
                });
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
        Message msg = Message.obtain();
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
