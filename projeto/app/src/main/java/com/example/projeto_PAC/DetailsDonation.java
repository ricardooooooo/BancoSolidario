package com.example.projeto_PAC;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class DetailsDonation extends AppCompatActivity {

    private static final String KEY_DONATIONPOSITION = "KEY_DONATIONPOSITION";

    public static void startActivity(Context context, long position) {
        Intent intent = new Intent(context, DetailsDonation.class);
        intent.putExtra(KEY_DONATIONPOSITION, position);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_donation);
    }
}