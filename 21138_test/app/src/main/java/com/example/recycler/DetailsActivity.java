package com.example.recycler;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    public static void startActivity(Context context, long position) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(KEY_COMPANYPOSITION, position);
        context.startActivity(intent);
    }

    private static final String KEY_COMPANYPOSITION = "COMPANYPOSITION";
    private static final String TAG = "Details Activity";

    private TextView textViewName;
    private TextView textViewAdress;
    private TextView textViewLocal;
    private TextView textViewPhoneNumber;

    private Company company;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.textViewName = findViewById(R.id.textViewName);
        this.textViewAdress = findViewById(R.id.textViewAdress);
        this.textViewLocal = findViewById(R.id.textViewLocal);
        this.textViewPhoneNumber = findViewById(R.id.textViewPhoneNumber);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            long position = bundle.getLong(KEY_COMPANYPOSITION, -1);
            if (position == -1) {
                Log.e(TAG, "Invalid position found!");
                finish();
            }

            this.company = AppDatabase.getInstance(this).getCompanyDao().getById(position);

            this.textViewName.setText(company.getName());
            this.textViewAdress.setText(company.getAdress());
            this.textViewLocal.setText(company.getLocal());
            this.textViewPhoneNumber.setText(String.valueOf(company.getPhoneNumber()));
        } else {
            Log.e(TAG, "No position specified!");
            finish();
        }

    }

    public void done(View view) {
        finish();
    }

    public void delete(View view) {
        Bundle bundle = getIntent().getExtras();
        long position = bundle.getLong(KEY_COMPANYPOSITION, -1);

        this.company = AppDatabase.getInstance(this).getCompanyDao().getById(position);

        AppDatabase.getInstance(this).getCompanyDao().delete(company);

        finish();
    }

    public void edit(View view) {
        String editCompany, editAddress, editLocal;
        int editPhone;

        this.textViewName = findViewById(R.id.textViewName);
        this.textViewAdress = findViewById(R.id.textViewAdress);
        this.textViewLocal = findViewById(R.id.textViewLocal);
        this.textViewPhoneNumber = findViewById(R.id.textViewPhoneNumber);

        Bundle bundle = getIntent().getExtras();
        long position = bundle.getLong(KEY_COMPANYPOSITION, -1);

        this.company = AppDatabase.getInstance(this).getCompanyDao().getById(position);

        editCompany = String.valueOf(textViewName.getText());
        editAddress = String.valueOf(textViewAdress.getText());
        editLocal = String.valueOf(textViewLocal.getText());
        editPhone = Integer.parseInt(String.valueOf(textViewPhoneNumber.getText()));
    }
}