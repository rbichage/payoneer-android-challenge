package com.reuben.payoneerchallenge.di;

import com.google.gson.Gson;
import com.reuben.payoneerchallenge.ApiService;
import com.reuben.payoneerchallenge.utils.HttpNetworkInterceptor;
import com.reuben.payoneerchallenge.utils.LoggingInterceptor;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class NetworkModule {
    private static final String BASE_URL = "https://raw.githubusercontent.com/optile/checkout-android/";

    @Provides
    @Singleton
    public static Gson provideGson() {
        return new Gson().newBuilder()
                .setLenient()
                .serializeNulls()
                .setPrettyPrinting()
                .create();
    }

    @Provides
    @Singleton
    public static OkHttpClient provideOkHttp() {
        return new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(new HttpNetworkInterceptor())
                .addNetworkInterceptor(LoggingInterceptor.getLogging())
                .build();
    }

    @Provides
    @Singleton
    public static Retrofit provideRetrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

    }

    @Provides
    public static ApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }
}
