package com.semako.asksa;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String BASE_URL = "http://192.168.43.144/asksa/";
    public static Retrofit retrofit;

    public static Retrofit getApiClient(){

        /*OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.connectTimeout(1, TimeUnit.MINUTES);
        client.readTimeout(30, TimeUnit.SECONDS);
        client.writeTimeout(15, TimeUnit.SECONDS);*/





        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    //.client(client.build())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

        }
        return retrofit;
    }
}
