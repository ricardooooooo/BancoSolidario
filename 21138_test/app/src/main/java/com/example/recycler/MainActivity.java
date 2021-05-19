package com.example.recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
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

        this.adapter = new RecyclerViewAdapter(this, DataSource.getCompanyList(this));
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

}