package com.example.projeto_PAC;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    public static void start(Context context) {
        Intent intent = new Intent(context, MainMenu.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        int codUser = SessionManager.getActiveSession(this);
        if (codUser == -1) finish();
        User user = AppDatabase.getInstance(this).getUserDao().getById(codUser);
        String userName = user.getUserName();
        if (userName.equals("monitor")){
            Button btnPendente;
            btnPendente = findViewById(R.id.btnPendente);
            btnPendente.setVisibility(View.VISIBLE);
        }
    }

    public void goToDonations(View view){
        Intent intent = new Intent(this, DonationActivity.class);
        startActivity(intent);
    }
    public void goToCompaniesAndFamilies(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
  public void goToTransactions(View view){
      Intent intent = new Intent(this, MainActivity.class);
      startActivity(intent);
  }

}