package com.example.projeto_PAC;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void login(View view) {
        List<User> user;
        EditText insertName, insertPassword;
        String name, password;

        insertName = findViewById(R.id.insertName);
        insertPassword = findViewById(R.id.insertPassword);

        name = String.valueOf(insertName.getText());
        password = String.valueOf(insertPassword.getText());

<<<<<<< HEAD


       
=======
        user = (List<User>) AppDatabase.getInstance(this).getUserDao().getByText(name, password);
>>>>>>> bf4e3f3dd86eb4b6ca3aebf90bc14d0870ab8014

        if(user == null){
            Toast.makeText(this, "Erro, os seus dados estão errados!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Login feito com sucesso!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}