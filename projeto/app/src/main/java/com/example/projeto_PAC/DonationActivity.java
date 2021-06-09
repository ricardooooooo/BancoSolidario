package com.example.projeto_PAC;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class DonationActivity extends AppCompatActivity {

    private DonationViewAdapter adapter;
    private List<Donation> donationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);


        int codUser = SessionManager.getActiveSession(this);
        if (codUser == -1) finish();
        User user = AppDatabase.getInstance(this).getUserDao().getById(codUser);
        String userName = user.getUserName();
        if (userName.equals("monitor")){
            RecyclerView recyclerView = findViewById(R.id.recyclerViewDonation);
            this.adapter = new DonationViewAdapter(this, AppDatabase.getInstance(this).getDonationDao().getAll());
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(this.adapter);
        }else {
            RecyclerView recyclerView = findViewById(R.id.recyclerViewDonation);
            this.adapter = new DonationViewAdapter(this, AppDatabase.getInstance(this).getDonationDao().getAutorizado());
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(this.adapter);
        }
    }


    @Override
    protected void onResume() {
        super.onResume();

        donationList = AppDatabase.getInstance(this).getDonationDao().getAutorizado();
        this.adapter.updateList(donationList);
    }

    public void goToAddNew(View view) {

    }
}