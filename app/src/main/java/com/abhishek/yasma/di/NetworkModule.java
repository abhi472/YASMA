package com.abhishek.yasma.di;

import com.abhishek.yasma.YASMApp;
import com.abhishek.yasma.remote.ApiService;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.abhishek.yasma.BuildConfig.SERVER_URL;

@Module
public class NetworkModule {

    private OkHttpClient buildOkHttpClient(YASMApp app) {
        return new OkHttpClient.Builder()
                .connectTimeout(10L, TimeUnit.SECONDS)
                .writeTimeout(10L, TimeUnit.SECONDS)
                .readTimeout(30L, TimeUnit.SECONDS)
                .addNetworkInterceptor(new StethoInterceptor())
                .build();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(YASMApp app) {
        return buildOkHttpClient(app);
    }


    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(SERVER_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }


    @Provides
    @Singleton
    ApiService provideNetworkService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }
}
