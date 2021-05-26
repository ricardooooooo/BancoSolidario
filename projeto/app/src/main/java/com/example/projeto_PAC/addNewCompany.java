package com.example.projeto_PAC;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class addNewCompany extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_company);
    }

    public void addNew(View view) {

        //TODO gettype aqui para se poder gravar cada no sitio

            EditText newCompany, newAddress, newLocal, newPhone;
            String companyName, address, local;
            int phoneNumber;

            newCompany = findViewById(R.id.newCompany);
            newAddress = findViewById(R.id.newAddress);
            newLocal = findViewById(R.id.newLocal);
            newPhone = findViewById(R.id.newNumber);

            companyName = String.valueOf(newCompany.getText());
            address = String.valueOf(newAddress.getText());
            local = String.valueOf(newLocal.getText());
            phoneNumber = Integer.parseInt(String.valueOf(newPhone.getText()));


            Company company1 = new Company(0, companyName, address, local, phoneNumber);
            AppDatabase.getInstance(this).getCompanyDao().add(company1);

            finish();
    }
}
