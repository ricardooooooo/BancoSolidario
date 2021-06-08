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

public class DonationActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private static final String KEY_TYPE ="TYPE";
    private RecyclerViewAdapter adapter;

    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        this.adapter = new RecyclerViewAdapter(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(this.adapter);

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.transaction, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        SearchView searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }


            @Override
            public boolean onQueryTextChange(String newText) {
                String type = (String) spinner.getSelectedItem();

                if(type.equals("Empresas")) {
                    DonationActivity.this.adapter.updateList(new ArrayList<BaseDataClass>(AppDatabase.getInstance(DonationActivity.this).getCompanyDao().getAllByText(newText)));
                    return true;
                }else
                {
                    DonationActivity.this.adapter.updateList(new ArrayList<BaseDataClass>(AppDatabase.getInstance(DonationActivity.this).getFamilyDao().getAllByText(newText)));
                    return true;
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String type = (String) spinner.getSelectedItem();

        if(type.equals("Empresas")) {
            this.adapter.updateList(new ArrayList<BaseDataClass>(AppDatabase.getInstance(this).getCompanyDao().getAll()));
            Toast.makeText(parent.getContext(), type, Toast.LENGTH_SHORT).show();
        }else{
            this.adapter.updateList(new ArrayList<BaseDataClass>(AppDatabase.getInstance(this).getFamilyDao().getAll()));
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        String type = (String) spinner.getSelectedItem();

        if(type.equals("Empresas")) {
            this.adapter.updateList(new ArrayList<BaseDataClass>(AppDatabase.getInstance(this).getCompanyDao().getAll()));
        }else{
            this.adapter.updateList(new ArrayList<BaseDataClass>(AppDatabase.getInstance(this).getFamilyDao().getAll()));
        }
    }

    public void goToAddNew(View view) {
        String type = (String) spinner.getSelectedItem();

        if(type.equals("Empresas")) {
            Intent intent = new Intent(this, addNewCompany.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent (this, addNewFamily.class);
            startActivity(intent);
        }

    }




}