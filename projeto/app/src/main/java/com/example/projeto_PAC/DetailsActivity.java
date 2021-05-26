package com.example.projeto_PAC;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class DetailsActivity extends AppCompatActivity {

    public static void startActivity(Context context, long id, String type) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(KEY_ID, id);
        intent.putExtra(KEY_TYPE, type);
        context.startActivity(intent);
    }


    private static final String KEY_ID = "ID";
    private static final String TAG = "DetailsActivity";
    private static final String KEY_TYPE = "TYPE";


    private TextView textViewName;

    private TextView textViewAddress;
    private TextView textViewLocal;
    private TextView textViewDescription;
    private TextView textViewPhone;

    private Company company;
    private Family family;


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
            long id = bundle.getLong(KEY_ID, -1);
            String type = bundle.getString(KEY_TYPE);

            if (id == -1) {
                Log.e(TAG, "Invalid position found!");
                finish();
                return;
            }


            if (type.equals(BaseDataClass.TYPE_COMPANY)) {

                this.company = AppDatabase.getInstance(this).getCompanyDao().getById(id);


                this.textViewName.setText(company.getName());
                this.textViewAddress.setText(company.getAddress());
                this.textViewLocal.setText(company.getLocal());
                this.textViewPhone.setText(String.valueOf(company.getPhoneNum()));
                this.textViewDescription.setText("Histórico de Doações");
            } else {

                this.family = AppDatabase.getInstance(this).getFamilyDao().getById(id);


                this.textViewName.setText(family.getName());
                this.textViewAddress.setText(family.getAddress());
                this.textViewLocal.setText(family.getLocal());
                this.textViewPhone.setText(String.valueOf(family.getPhoneNum()));
                this.textViewDescription.setText("Histórico de Doações");

               // Log.e(TAG, "erro no typebundle!");
               // Log.e(TAG, "No position specified!");
               // finish();
            }
        }
    }
}