package com.example.projeto_PAC;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DetailsDonation extends AppCompatActivity {

    private static final String KEY_DONATION_ID = "KEY_DONATIONPOSITION";

    public static void startActivity(Context context, long id) {
        Intent intent = new Intent(context, DetailsDonation.class);
        intent.putExtra(KEY_DONATION_ID, id);
        context.startActivity(intent);
    }

    private static final String TAG = "DetailsActivity";


    private Donation donation;
    private Company company;
    private Family family;

    private TextView txtDonator;
    private TextView txtReceiver;
    private TextView txtAmount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_donation);


        this.txtDonator = findViewById(R.id.txtDonator);
        this.txtReceiver = findViewById(R.id.txtReceiver);
        this.txtAmount = findViewById(R.id.txtAmount);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            long id = bundle.getLong(KEY_DONATION_ID, -1);

            if (id == -1) {
                Log.e(TAG, "Invalid position found!");
                finish();
                return;
            }

            this.donation = AppDatabase.getInstance(this).getDonationDao().getById(id);
            this.company = AppDatabase.getInstance(this).getCompanyDao().getById(this.donation.getCodCompany());
            this.family = AppDatabase.getInstance(this).getFamilyDao().getById(this.donation.getCodFamily());


            this.txtAmount.setText(String.valueOf(this.donation.getAmount()));
            this.txtReceiver.setText(String.valueOf(this.family.getName()));
            this.txtDonator.setText(String.valueOf(this.company.getName()));

        }
    }
}