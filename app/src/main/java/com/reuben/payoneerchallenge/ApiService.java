package com.reuben.payoneerchallenge;

import com.reuben.payoneerchallenge.data.models.PaymentResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("develop/shared-test/lists/listresult.json")
    Call<PaymentResponse> getPayments();
}
