package com.example.demo3.network;

import android.util.Log;

import com.example.demo3.bean.MyMessage;
import com.example.demo3.network.api.MessageApi;
import com.google.gson.Gson;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.demo3.utils.Constant.WEB_SITE;

public class NetWork {

    private Retrofit mRetrofit;
    private OkHttpClient client;
    private MessageApi messageApi;

    private volatile static NetWork instance = null;
    private NetWork(){
        client = new OkHttpClient();
    }
    public static NetWork getInstance(){
        if(instance == null){
            synchronized (NetWork.class){
                if(instance == null){
                    instance = new NetWork();
                }
            }
        }
        return instance;
    }


    public MessageApi getMessageData(){
        if(messageApi == null){
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(WEB_SITE)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            messageApi = mRetrofit.create(MessageApi.class);
        }
        Log.d("NetWork", "api:" + messageApi);
        return messageApi;

    }

}
