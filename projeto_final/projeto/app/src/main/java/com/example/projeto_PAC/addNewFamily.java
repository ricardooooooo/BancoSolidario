package com.example.projeto_PAC;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class addNewFamily extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_family);
    }

    public void addNewFamily(View view) {
        EditText newFamily, newAddress, newLocal, newPhone;
        String familyName, address, local;
        int phoneNumber = 0;

        newFamily = findViewById(R.id.newFamily);
        newAddress = findViewById(R.id.newAddressFamily);
        newLocal = findViewById(R.id.newLocalFamily);
        newPhone = findViewById(R.id.newNumberFamily);

       try {
            familyName = String.valueOf(newFamily.getText());
            address = String.valueOf(newAddress.getText());
            local = String.valueOf(newLocal.getText());
            try {
                phoneNumber = Integer.parseInt(String.valueOf(newPhone.getText())); 
            } catch (Exception ignored) {
            }
            
            if (familyName.isEmpty() || address.isEmpty() || local.isEmpty() || phoneNumber == 0){
                Toast.makeText(this, "Erro, tem de preencher os dados de modo a criar uma nova familia", Toast.LENGTH_SHORT).show();
            }else {
                Family family1 = new Family(0, familyName, address, local, phoneNumber);
                AppDatabase.getInstance(this).getFamilyDao().add(family1);
                finish();
            }
        }
        catch(Exception e) {
           e.printStackTrace();
           Log.e(String.valueOf(e), "Error");
        }

    }
}