package com.example.recycler;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    public static void startActivity(Context context, long position) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(KEY_COMPANYPOSITION, position);
        context.startActivity(intent);
    }

    private static final String KEY_COMPANYPOSITION = "COMPANYPOSITION";
    private static final String TAG = "Details Activity";

    private EditText editName;
    private EditText editAdress;
    private EditText editLocal;
    private EditText editPhone;

    private Company company;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.editName = findViewById(R.id.editCompany);
        this.editAdress = findViewById(R.id.editAdress);
        this.editLocal = findViewById(R.id.editLocal);
        this.editPhone = findViewById(R.id.editPhone);

        this.editName.setEnabled(false);
        this.editAdress.setEnabled(false);
        this.editLocal.setEnabled(false);
        this.editPhone.setEnabled(false);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            long position = bundle.getLong(KEY_COMPANYPOSITION, -1);
            if (position == -1) {
                Log.e(TAG, "Invalid position found!");
                finish();
            }

            this.company = AppDatabase.getInstance(this).getCompanyDao().getById(position);

            this.editName.setText(company.getName());
            this.editAdress.setText(company.getAdress());
            this.editLocal.setText(company.getLocal());
            this.editPhone.setText(String.valueOf(company.getPhoneNumber()));
        } else {
            Log.e(TAG, "No position specified!");
            finish();
        }
    }

    public void delete(View view) {
        Bundle bundle = getIntent().getExtras();
        long position = bundle.getLong(KEY_COMPANYPOSITION, -1);

        this.company = AppDatabase.getInstance(this).getCompanyDao().getById(position);

        AppDatabase.getInstance(this).getCompanyDao().delete(company);

        finish();
    }

    public void edit(View view) {
        Button btnDone;
        btnDone = findViewById(R.id.btnDone);

        btnDone.setVisibility(View.VISIBLE);

        this.editName.setEnabled(true);
        this.editAdress.setEnabled(true);
        this.editLocal.setEnabled(true);
        this.editPhone.setEnabled(true);
    }

    public void done(View view) {
        String editCompany, editAddress, textEditLocal;
        int editTextPhone;

        this.editName = findViewById(R.id.editCompany);
        this.editAdress = findViewById(R.id.editAdress);
        this.editLocal = findViewById(R.id.editLocal);
        this.editPhone = findViewById(R.id.editPhone);

        editCompany = String.valueOf(editName.getText());
        editAddress = String.valueOf(editAdress.getText());
        textEditLocal = String.valueOf(editLocal.getText());
        editTextPhone = Integer.parseInt(String.valueOf(editPhone.getText()));
        
        this.company.setName(editCompany);
        this.company.setAdress(editAddress);
        this.company.setLocal(textEditLocal);
        this.company.setPhoneNumber(editTextPhone);

        AppDatabase.getInstance(this).getCompanyDao().update(this.company);

        finish();
    }
}