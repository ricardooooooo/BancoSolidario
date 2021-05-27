package com.example.projeto_PAC;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class addNewCompany extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_company);
    }

    public void addNew(View view) {

            EditText newCompany, newAddress, newLocal, newPhone;
            String companyName, address, local;
            int phoneNumber = 0;

            newCompany = findViewById(R.id.newFamily);
            newAddress = findViewById(R.id.newAddressFamily);
            newLocal = findViewById(R.id.newLocalFamily);
            newPhone = findViewById(R.id.newNumberFamily);

        try {
            companyName = String.valueOf(newCompany.getText());
            address = String.valueOf(newAddress.getText());
            local = String.valueOf(newLocal.getText());
            try {
                phoneNumber = Integer.parseInt(String.valueOf(newPhone.getText()));
            } catch (Exception ignored) {
            }

            if (companyName.isEmpty() || address.isEmpty() || local.isEmpty() || phoneNumber == 0){
                    Toast.makeText(this, "Erro, tem de preencher os dados de modo a criar uma nova empresa", Toast.LENGTH_LONG).show();
            }else {
                Company company1 = new Company(0, companyName, address, local, phoneNumber);
                AppDatabase.getInstance(this).getCompanyDao().add(company1);
                finish();
            }
        }
        catch(Exception e) {
            Log.e(String.valueOf(e), "Error");
        }
    }
}
