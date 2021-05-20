package com.example.recyclerviewtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




//-----------------------------------
         spinner = (Spinner) findViewById(R.id.spinner);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.transaction, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      //  String text = parent.getItemAtPosition(position).toString();
        RecyclerViewAdapter adapter1;

        //String text1 = spinner.getSelectedItem().toString();
        String text = (String) spinner.getSelectedItem();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        if(text.equals("Empresas")) {
            adapter1 = new RecyclerViewAdapter(this, AppDatabase.getInstance(this).getCompanyDao().getAll());

            Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
        }else{
            adapter1 = new RecyclerViewAdapter(this, AppDatabase.getInstance(this).getFamilyDao().getAll());
        }
        recyclerView.setAdapter(adapter1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
   public void onNothingSelected(AdapterView<?> parent) {

    }
}

//https://stackoverflow.com/questions/44842456/how-to-apply-filter-in-recyclerview-based-on-spinner-item-selection