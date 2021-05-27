package com.reuben.payoneerchallenge.ui.home;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.snackbar.Snackbar;
import com.reuben.payoneerchallenge.data.models.Applicable;
import com.reuben.payoneerchallenge.databinding.ActivityMainBinding;
import com.reuben.payoneerchallenge.ui.newtworkDetails.DetailsBottomSheet;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;
import timber.log.Timber;

@AndroidEntryPoint
public class HomeActivity extends AppCompatActivity implements OnNetworkItemClicked {

    private HomeViewModel homeViewModel;
    private PaymentsAdapter paymentsAdapter;
    private ActivityMainBinding binding;
    private OnNetworkItemClicked onNetworkItemClicked;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        onNetworkItemClicked = this;

        setupNav();
        initialiseViewModel();
    }

    private void setupNav() {
        setSupportActionBar(binding.toolbar);

        binding.toolbar.setNavigationOnClickListener(v -> onBackPressed());
    }

    private void initialiseViewModel() {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        observeViewViewModel();

        getNetworks();
    }

    private void observeViewViewModel() {
        homeViewModel.paymentResponse.observe(this, paymentResponse -> {

            List<Applicable> applicableList = paymentResponse.getNetworks().getApplicable();

            if (!applicableList.isEmpty()) {
                paymentsAdapter = new PaymentsAdapter(applicableList, this);
                binding.paymentsRecycler.setAdapter(paymentsAdapter);
            }
        });

        homeViewModel.errorBody.observe(this, errorHolder -> {
            Timber.e("error body: %s", errorHolder.getStatusCode());
            showErrorSnackbar(errorHolder.getMessage());
        });

        homeViewModel.isLoading.observe(this, isLoading -> {
            if (isLoading) {
                binding.loadingProgress.setVisibility(View.VISIBLE);
            } else {
                binding.loadingProgress.setVisibility(View.GONE);
            }
        });
    }

    public void getNetworks() {
        homeViewModel.getPayments();
    }

    private void showErrorSnackbar(String message) {
        Snackbar snackbar = Snackbar.make(binding.getRoot(), message, Snackbar.LENGTH_INDEFINITE);

        snackbar.show();
        snackbar.setAction("RETRY", v -> {
            snackbar.dismiss();
            getNetworks();
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onNetworkItemClicked = null;
    }

    @Override
    public void getNetwork(Applicable applicable) {
        DetailsBottomSheet detailsBottomSheet = new DetailsBottomSheet(applicable);

        detailsBottomSheet.show(getSupportFragmentManager().beginTransaction(), applicable.getCode());
    }
}