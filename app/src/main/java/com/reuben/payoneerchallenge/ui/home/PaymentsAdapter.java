package com.reuben.payoneerchallenge.ui.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.reuben.payoneerchallenge.R;
import com.reuben.payoneerchallenge.data.models.Applicable;
import com.reuben.payoneerchallenge.databinding.LayoutPaymentItemBinding;

public class PaymentsAdapter extends ListAdapter<Applicable, PaymentsAdapter.PaymentsViewHolder> {

    private final OnNetworkItemClicked onNetworkItemClicked;


    public PaymentsAdapter(OnNetworkItemClicked onNetworkItemClicked) {
        super(new DiffUtil.ItemCallback<Applicable>() {
            @Override
            public boolean areItemsTheSame(@NonNull Applicable oldItem, @NonNull Applicable newItem) {
                return oldItem.getCode().equals(newItem.getCode());
            }

            @Override
            public boolean areContentsTheSame(@NonNull Applicable oldItem, @NonNull Applicable newItem) {
                return oldItem.getLabel().equals(newItem.getLabel());
            }
        });
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
        Applicable applicable = getItem(position);
        LayoutPaymentItemBinding binding = holder.binding;

        binding.tvPaymentName.setText(applicable.getLabel());

        Glide.with(binding.getRoot().getContext())
                .load(applicable.getLinks().getLogo())
                .placeholder(R.drawable.ic_baseline_credit_card_24)
                .into(binding.imgNetworkSrc);

        binding.getRoot().setOnClickListener(v -> onNetworkItemClicked.getNetwork(applicable));


    }


    static class PaymentsViewHolder extends RecyclerView.ViewHolder {
        LayoutPaymentItemBinding binding;


        public PaymentsViewHolder(LayoutPaymentItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }


    }

}




