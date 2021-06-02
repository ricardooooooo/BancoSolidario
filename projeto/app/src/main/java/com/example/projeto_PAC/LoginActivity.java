package com.example.projeto_PAC;

import androidx.appcompat.app.AppCompatActivity;

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
        User user1;
        EditText insertName, insertPassword;
        String name, password;

        insertName = findViewById(R.id.insertName);
        insertPassword = findViewById(R.id.insertPassword);

        name = String.valueOf(insertName.getText());
        password = String.valueOf(insertPassword.getText());



        user1 = AppDatabase.getInstance(this).getUserDao().getByText(name, password);
        //user1 = new User(1 ,"admin","admin","teste");
        user1 = new User(1,name,password,"teste");


        if(user1 == null){
            Toast.makeText(this, "Erro, os seus dados estão errados!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Login feito com sucesso!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}