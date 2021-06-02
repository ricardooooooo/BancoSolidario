package com.example.projeto_PAC;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void goToDonations(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void goToCompaniesAndFamilies(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
  /*  private void goToFamilies(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }*/
  public void goToTransactions(View view){
      Intent intent = new Intent(this, MainActivity.class);
      startActivity(intent);
  }

}