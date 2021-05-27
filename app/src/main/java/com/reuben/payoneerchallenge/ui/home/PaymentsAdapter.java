package com.reuben.payoneerchallenge.ui.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.reuben.payoneerchallenge.R;
import com.reuben.payoneerchallenge.data.models.Applicable;
import com.reuben.payoneerchallenge.databinding.LayoutPaymentItemBinding;

import java.util.List;

public class PaymentsAdapter extends RecyclerView.Adapter<PaymentsAdapter.PaymentsViewHolder> {

    private final List<Applicable> applicables;
    private final OnNetworkItemClicked onNetworkItemClicked;

    public PaymentsAdapter(List<Applicable> applicables, OnNetworkItemClicked onNetworkItemClicked) {
        this.applicables = applicables;
        this.onNetworkItemClicked = onNetworkItemClicked;
    }

    @NonNull
    @Override
    public PaymentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutPaymentItemBinding binding = LayoutPaymentItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PaymentsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentsViewHolder holder, int position) {
        Applicable applicable = applicables.get(position);
        LayoutPaymentItemBinding binding = holder.binding;

        binding.tvPaymentName.setText(applicable.getLabel());

        Glide.with(binding.getRoot().getContext())
                .load(applicable.getLinks().getLogo())
                .placeholder(R.drawable.ic_baseline_credit_card_24)
                .into(binding.imgNetworkSrc);

        binding.getRoot().setOnClickListener(v -> onNetworkItemClicked.getNetwork(applicable));


    }

    @Override
    public int getItemCount() {
        return applicables.size();
    }

    static class PaymentsViewHolder extends RecyclerView.ViewHolder {
        LayoutPaymentItemBinding binding;


        public PaymentsViewHolder(LayoutPaymentItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }


    }


}


