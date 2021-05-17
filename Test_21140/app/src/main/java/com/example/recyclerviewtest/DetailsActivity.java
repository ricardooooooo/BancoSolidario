package com.example.recyclerviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;


public class DetailsActivity extends AppCompatActivity {

    public static void startActivity(Context context, int position) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(KEY_COMPANYPOSITION, position);
        context.startActivity(intent);
    }

    private static final String KEY_COMPANYPOSITION = "COMPANYPOSITION";





    private static final String TAG = "DetailsActivity";


    private TextView textViewName;

    private TextView textViewAdress;
    private TextView textViewLocal;
    private TextView textViewDescription;
    private TextView textViewPhone;

    private Company company;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        this.textViewName = findViewById(R.id.textViewName);
        this.textViewAdress = findViewById(R.id.textViewAdress);
        this.textViewLocal = findViewById(R.id.textViewLocal);
        this.textViewPhone = findViewById(R.id.textViewPhone);
        this.textViewDescription = findViewById(R.id.textViewDescription);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int position = bundle.getInt(KEY_COMPANYPOSITION, -1);
            if (position == -1) {
                Log.e(TAG, "Invalid position found!");
                finish();
            }

            this.company = DataSource.getCompany(position);



            this.textViewName.setText(company.getName());
            this.textViewAdress.setText(company.getAdress());
            this.textViewLocal.setText(company.getLocal());
            this.textViewPhone.setText(String.valueOf(company.getPhoneNum()));
            this.textViewDescription.setText("Histórico de Doações");

        } else {
            Log.e(TAG, "No position specified!");
            finish();
        }
    }
}