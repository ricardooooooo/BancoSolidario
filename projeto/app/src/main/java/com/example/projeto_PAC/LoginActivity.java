package com.example.projeto_PAC;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void login(View view) {
        EditText insertName, insertPassword;
        String name, password;

        insertName = findViewById(R.id.insertName);
        insertPassword = findViewById(R.id.insertPassword);

        name = String.valueOf(insertName.getText());
        password = String.valueOf(insertPassword.getText());

        User user = AppDatabase.getInstance(this).getUserDao().login(name, password);


        if(user == null){
            Toast.makeText(this, "Erro, os seus dados estão errados!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Login feito com sucesso!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}