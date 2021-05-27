package com.reuben.payoneerchallenge.ui.newtworkDetails;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.reuben.payoneerchallenge.R;
import com.reuben.payoneerchallenge.data.models.Applicable;
import com.reuben.payoneerchallenge.databinding.DialogNetworkDetailsBinding;

import dagger.hilt.android.AndroidEntryPoint;
import timber.log.Timber;

@AndroidEntryPoint
public class DetailsBottomSheet extends BottomSheetDialogFragment {
    private Applicable applicable;
    private DialogNetworkDetailsBinding binding;

    public DetailsBottomSheet(Applicable applicable) {
        this.applicable = applicable;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DialogNetworkDetailsBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Timber.e("applicable details %s", applicable);

        setupViews();

    }

    private void setupViews() {
        Glide.with(binding.getRoot())
                .load(applicable.getLinks().getLogo())
                .placeholder(R.drawable.ic_baseline_credit_card_24)
                .into(binding.imgCard);

        binding.tvCardName.setText(applicable.getLabel());
    }


}
