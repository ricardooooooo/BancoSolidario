package com.example.recyclerviewtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ResourceCursorAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;


import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{


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
}

//https://stackoverflow.com/questions/44842456/how-to-apply-filter-in-recyclerview-based-on-spinner-item-selection