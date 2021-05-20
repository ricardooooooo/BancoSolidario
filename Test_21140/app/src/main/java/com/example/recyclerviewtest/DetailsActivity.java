package com.example.recyclerviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class DetailsActivity extends AppCompatActivity {

    public static void startActivity(Context context, int position) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(KEY_CODCOMPANY, position);
        context.startActivity(intent);
    }

    private static final String KEY_CODCOMPANY = "CODCOMPANY";
    private static final String TAG = "DetailsActivity";


    private TextView textViewName;

    private TextView textViewAddress;
    private TextView textViewLocal;
    private TextView textViewDescription;
    private TextView textViewPhone;

    private Company company;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.textViewName = findViewById(R.id.textViewName);
        this.textViewAddress = findViewById(R.id.textViewAdress);
        this.textViewLocal = findViewById(R.id.textViewLocal);
        this.textViewPhone = findViewById(R.id.textViewPhone);
        this.textViewDescription = findViewById(R.id.textViewDescription);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            long position = bundle.getInt(KEY_CODCOMPANY, -1);
            if (position == -1) {
                Log.e(TAG, "Invalid position found!");
                finish();
                return;
            }

            this.company = AppDatabase.getInstance(this).getCompanyDao().getById(position);



            this.textViewName.setText(company.getName());
            this.textViewAddress.setText(company.getAddress());
            this.textViewLocal.setText(company.getLocal());
            this.textViewPhone.setText(String.valueOf(company.getPhoneNum()));
            this.textViewDescription.setText("Histórico de Doações");

        } else {
            Log.e(TAG, "No position specified!");
            finish();
        }
    }
}