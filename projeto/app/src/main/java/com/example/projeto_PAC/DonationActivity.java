package com.example.projeto_PAC;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.List;

public class DonationActivity extends AppCompatActivity {

    private DonationViewAdapter adapter;
    private List<Donation> donationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewDonation);
        this.adapter = new DonationViewAdapter(this, AppDatabase.getInstance(this).getDonationDao().getAll());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(this.adapter);

    }


    @Override
    protected void onResume() {
        super.onResume();

        donationList = AppDatabase.getInstance(this).getDonationDao().getAll();
        this.adapter.updateList(donationList);

    }

    public void goToAddNew(View view) {



    }




}