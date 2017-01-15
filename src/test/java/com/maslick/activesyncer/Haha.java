package com.maslick.activesyncer;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.List;

/**
 * Created by maslick on 15/01/17.
 */
public interface Haha {
    @POST("post")
    Call<Message> syncNow(@Body List<Datum> datas);
}
