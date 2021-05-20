package com.example.recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerViewAdapter adapter;
    Context context;
    List<Company> companyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        this.adapter = new RecyclerViewAdapter(this, AppDatabase.getInstance(this).getCompanyDao().getAll());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        SearchView searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            //Este aqui atualiza a clicar na lupa, mais otimizado pois não esta sempre a percorrer a lista
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            //Este aqui atualiza a cada mudança de letra, menos otimizado pois esta sempre a percorrer a lista
            @Override
            public boolean onQueryTextChange(String newText) {
                companyList = AppDatabase.getInstance(MainActivity.this).getCompanyDao().getAllByText(newText);
                adapter.updateList(companyList);
                return true;
            }
        });

    }

    public void newCompany(View view) {
        Intent intent = new Intent(this, addNewCompany.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();

         companyList = AppDatabase.getInstance(MainActivity.this).getCompanyDao().getAll();
        adapter.updateList(companyList);
    }
}