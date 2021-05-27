package com.reuben.payoneerchallenge.ui.home;

import com.reuben.payoneerchallenge.ApiService;
import com.reuben.payoneerchallenge.data.models.PaymentResponse;

import javax.inject.Inject;

import retrofit2.Call;

public class HomeRepository {
    private final ApiService apiService;

    @Inject
    public HomeRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public Call<PaymentResponse> getPaymentNetworks() {
        return apiService.getPayments();
    }
}
