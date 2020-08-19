package com.example.demo3.network.api;

import com.example.demo3.bean.FlyRouteBean;
import com.example.demo3.bean.MyMessage;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MessageApi {
    @GET("search")
    Observable<List<MyMessage>> search(@Query("q") String query);

    @Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
    @POST("search?q=110")
    Observable<List<MyMessage>> request(@Body RequestBody route);//传入的参数为RequestBody
}
