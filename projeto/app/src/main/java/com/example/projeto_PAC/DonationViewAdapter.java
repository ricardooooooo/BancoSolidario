package com.example.projeto_PAC;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DonationViewAdapter {
    private List<Donation> donationList;
    private Context context;

    public DonationViewAdapter(Context context) {
        this.context = context;
        this.donationList = new ArrayList<>();
    }

    @NonNull
    @Override
    public DonationViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new DonationViewAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DonationViewAdapter.ViewHolder holder, int position) {
        Donation donation = this.donationList.get(position);
        holder.getTextView().setText(donation.getAmmount());


        holder.getParentLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Sempre que clicar no parent layout, este código é executado
                Log.i("DonationViewAdapter", String.format("Clicked on: %s (position %d)", data.getName(), position));

                DetailsActivity.startActivity(DonationViewAdapter.this.context, data.getId(), data.getType());
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.donationList.size();
    }

    public void updateList(List<Donation> newList) {
        this.donationList = newList;
        this.notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final View parentLayout;
        private final TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textView = itemView.findViewById(R.id.textView);
            this.parentLayout = itemView.findViewById(R.id.parentLayout);
        }

        public TextView getTextView() {
            return textView;
        }


        public View getParentLayout() { return parentLayout; }
    }
}