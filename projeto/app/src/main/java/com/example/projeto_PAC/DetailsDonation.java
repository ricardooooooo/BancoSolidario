package com.example.projeto_PAC;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DetailsDonation extends AppCompatActivity {

    private static final String KEY_DONATIONPOSITION = "KEY_DONATIONPOSITION";

    public static void startActivity(Context context, long id) {
        Intent intent = new Intent(context, DetailsDonation.class);
        intent.putExtra(KEY_DONATIONPOSITION, id);
        context.startActivity(intent);
    }

    private static final String TAG = "DetailsActivity";


    private Donation donation;

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
            long id = bundle.getLong(KEY_DONATIONPOSITION, -1);

            if (id == -1) {
                Log.e(TAG, "Invalid position found!");
                finish();
                return;
            }



                this.donation = AppDatabase.getInstance(this).getDonationDao().getById(id);

             /*   this.editName.setText(company.getName());
                this.editAddress.setText(company.getAddress());
                this.editLocal.setText(company.getLocal());
                this.editPhone.setText(String.valueOf(company.getPhoneNum()));
                this.textViewDescription.setText("Histórico de Doações");


*/


            }



    }
}