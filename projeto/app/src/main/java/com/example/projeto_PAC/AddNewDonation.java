package com.example.projeto_PAC;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddNewDonation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_donation);
    }

    public void addPendingDonation(View view) {
        EditText textCompany, textFamily, textAmount;
        Long codCompany, codFamily;
        int amount;

        textCompany = findViewById(R.id.editCodCompany);
        textFamily = findViewById(R.id.editCodFamily);
        textAmount = findViewById(R.id.editAmount);

        try {
            codCompany = Long.valueOf(String.valueOf(textCompany.getText()));
            codFamily = Long.valueOf(String.valueOf(textFamily.getText()));
            amount = Integer.valueOf(String.valueOf(textAmount.getText()));

            if (codCompany == 0 || codFamily == 0 || amount == 0){
                Toast.makeText(this, "Erro, tem de preencher os dados de modo a criar uma nova doação", Toast.LENGTH_LONG).show();
            }else {
                Donation donation = new Donation(0, codCompany, codFamily, amount, false);
                AppDatabase.getInstance(this).getDonationDao().add(donation);
                finish();
            }
        }
        catch(Exception e) {
            Log.e(String.valueOf(e), "Error");
        }
    }
}