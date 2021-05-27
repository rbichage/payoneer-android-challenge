package com.reuben.payoneerchallenge.utils;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HttpNetworkInterceptor implements Interceptor {
    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request request = chain.request();

        Request newRequest = request.newBuilder()
                .header("Content-Type", "application/json")
                .build();

        return chain.proceed(newRequest);
    }
}
