package com.example.projeto_PAC;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class DonationViewAdapter extends RecyclerView.Adapter<DonationViewAdapter.ViewHolder> {
    private final String typeUser;
    private List<Donation> donationList;
    private Context context;

    public DonationViewAdapter(Context context, List<Donation> donationList, String type_user) {
        this.context = context;
        this.donationList =  donationList;
        this.typeUser = type_user;
    }

    @NonNull
    @Override
    public DonationViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_donation, parent, false);
        return new DonationViewAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DonationViewAdapter.ViewHolder holder, int position) {
        Donation donation = this.donationList.get(position);

        long codCompany = donation.getCodCompany();
        Company company = AppDatabase.getInstance(DonationViewAdapter.this.context).getCompanyDao().getById(codCompany);
        holder.getTextView1().setText(Integer.toString(donation.amount));
        holder.getTextView().setText(company.getName());

        holder.checkbox.setChecked(donation.flg_Pendente);

        holder.getParentLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Sempre que clicar no parent layout, este código é executado
                Log.i("DonationViewAdapter", String.format("Clicked on: %s (position %d)", donation.getAmount(), position));
                DetailsDonation.startActivity(DonationViewAdapter.this.context, donation.getCodDonation());
            }
        });

        holder.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                donation.setFlg_Pendente(isChecked);
                AppDatabase.getInstance(DonationViewAdapter.this.context).getDonationDao().update(donation);
            }
        });

        if (!this.typeUser.equals("M") || this.typeUser.equals("A")) {
            holder.checkbox.setVisibility(View.INVISIBLE);
        }
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
        private final TextView textView1;
        private final CheckBox checkbox;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textView = itemView.findViewById(R.id.textView);
            this.textView1 = itemView.findViewById(R.id.textView1);
            this.parentLayout = itemView.findViewById(R.id.parentLayout);
            this.checkbox = itemView.findViewById(R.id.checkBox);
        }

        public TextView getTextView() {
            return textView;
        }

        public TextView getTextView1(){return textView1;}

        public View getParentLayout() { return parentLayout; }

        public CheckBox getCheckbox(){return checkbox;}
    }
}
