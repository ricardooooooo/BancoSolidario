package com.example.projeto_PAC;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DonationActivity extends AppCompatActivity {

    private DonationViewAdapter adapter;
    private List<Donation> donationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
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