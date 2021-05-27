package com.reuben.payoneerchallenge.ui.home;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.reuben.payoneerchallenge.data.models.PaymentResponse;
import com.reuben.payoneerchallenge.data.other.ErrorHolder;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@HiltViewModel
public class HomeViewModel extends ViewModel {
    private final HomeRepository homeRepository;

    private final MutableLiveData<ErrorHolder> _errorBody = new MutableLiveData<>();
    private final MutableLiveData<PaymentResponse> _paymentResponse = new MutableLiveData<>();
    private final MutableLiveData<Boolean> _isLoading = new MutableLiveData<>();
    public LiveData<ErrorHolder> errorBody = _errorBody;
    public LiveData<PaymentResponse> paymentResponse = _paymentResponse;
    public LiveData<Boolean> isLoading = _isLoading;


    @Inject
    public HomeViewModel(HomeRepository homeRepository) {
        this.homeRepository = homeRepository;
    }

    public void getPayments() {
        _isLoading.setValue(true);
        homeRepository.getPaymentNetworks().enqueue(new Callback<PaymentResponse>() {
            @Override
            public void onResponse(@NonNull Call<PaymentResponse> call, @NonNull Response<PaymentResponse> response) {
                _isLoading.setValue(false);

                if (response.isSuccessful()) {
                    _paymentResponse.setValue(response.body());
                } else {
                    int errorCode = response.code();
                    String errorMessage;

                    try {
                        JSONObject jsonObject = new JSONObject(response.errorBody().string());

                        if (jsonObject.has("message")) {
                            errorMessage = jsonObject.getString("message");
                        } else {
                            errorMessage = "Unable to complete your request";
                        }
                        _errorBody.setValue(new ErrorHolder(errorMessage, errorCode));
                    } catch (JSONException | IOException e) {
                        errorMessage = "Unable to complete your request";
                        _errorBody.setValue(new ErrorHolder(errorMessage, errorCode));
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(@NonNull Call<PaymentResponse> call, @NonNull Throwable t) {

                _isLoading.setValue(false);
                _errorBody.setValue(new ErrorHolder("Unable to connect, check your connection", 0));
            }
        });
    }
}
