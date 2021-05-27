package com.example.projeto_PAC;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class DetailsActivity extends AppCompatActivity {

    public static void startActivity(Context context, long id, String type) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(KEY_ID, id);
        intent.putExtra(KEY_TYPE, type);
        context.startActivity(intent);
    }


    private static final String KEY_ID = "ID";
    private static final String TAG = "DetailsActivity";
    private static final String KEY_TYPE = "TYPE";


    private EditText editName;
    private EditText editAddress;
    private EditText editLocal;
    private EditText editPhone;

    Button btnDone;

    private TextView textViewDescription;
    private Company company;
    private Family family;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        btnDone = findViewById(R.id.btnDone);

        btnDone.setVisibility(View.INVISIBLE);

        this.editName = findViewById(R.id.editName);
        this.editAddress = findViewById(R.id.editAddress);
        this.editLocal = findViewById(R.id.editLocal);
        this.editPhone = findViewById(R.id.editPhone);
        this.textViewDescription = findViewById(R.id.textViewDescription);

        editName.setEnabled(false);
        editAddress.setEnabled(false);
        editLocal.setEnabled(false);
        editPhone.setEnabled(false);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            long id = bundle.getLong(KEY_ID, -1);
            String type = bundle.getString(KEY_TYPE);

            if (id == -1) {
                Log.e(TAG, "Invalid position found!");
                finish();
                return;
            }

            if (type.equals(BaseDataClass.TYPE_COMPANY)) {

                this.company = AppDatabase.getInstance(this).getCompanyDao().getById(id);

                this.editName.setText(company.getName());
                this.editAddress.setText(company.getAddress());
                this.editLocal.setText(company.getLocal());
                this.editPhone.setText(String.valueOf(company.getPhoneNum()));
                this.textViewDescription.setText("Histórico de Doações");
            } else {

                this.family = AppDatabase.getInstance(this).getFamilyDao().getById(id);

                this.editName.setText(family.getName());
                this.editAddress.setText(family.getAddress());
                this.editLocal.setText(family.getLocal());
                this.editPhone.setText(String.valueOf(family.getPhoneNum()));
                this.textViewDescription.setText("Histórico de Doações");

                // Log.e(TAG, "erro no typebundle!");
                // Log.e(TAG, "No position specified!");
                // finish();
            }
        }
    }

    public void deleteCurrent(View view) {
        Bundle bundle = getIntent().getExtras();
        long id = bundle.getLong(KEY_ID, -1);
        String type = bundle.getString(KEY_TYPE);

        if (type.equals(BaseDataClass.TYPE_COMPANY)) {
            this.company = AppDatabase.getInstance(this).getCompanyDao().getById(id);

            AppDatabase.getInstance(this).getCompanyDao().delete(company);
        }else {
            this.family = AppDatabase.getInstance(this).getFamilyDao().getById(id);

            AppDatabase.getInstance(this).getFamilyDao().delete(family);
        }
        finish();
    }

    public void editCurrent(View view) {
        btnDone = findViewById(R.id.btnDone);

        btnDone.setVisibility(View.VISIBLE);

        this.editName.setEnabled(true);
        this.editAddress.setEnabled(true);
        this.editLocal.setEnabled(true);
        this.editPhone.setEnabled(true);
    }

    public void doneEdit(View view) {
        Bundle bundle = getIntent().getExtras();
        long id = bundle.getLong(KEY_ID, -1);
        String type = bundle.getString(KEY_TYPE);

        String editName, editAddressString, textEditLocal;
        int editTextPhone = 0;

        this.editName = findViewById(R.id.editName);
        this.editAddress = findViewById(R.id.editAddress);
        this.editLocal = findViewById(R.id.editLocal);
        this.editPhone = findViewById(R.id.editPhone);

        try {
            editName = String.valueOf(this.editName.getText());
            editAddressString = String.valueOf(editAddress.getText());
            textEditLocal = String.valueOf(editLocal.getText());
            try {
                editTextPhone = Integer.parseInt(String.valueOf(editPhone.getText()));
            } catch (Exception ignored) {
            }

            if (type.equals(BaseDataClass.TYPE_COMPANY)) {
                if (editName.isEmpty() || editAddressString.isEmpty() || textEditLocal.isEmpty() || editTextPhone == 0) {
                    Toast.makeText(this, "Erro, não pode tirar os dados todos da empresa!", Toast.LENGTH_LONG).show();
                }else {
                    this.company = AppDatabase.getInstance(this).getCompanyDao().getById(id);

                    this.company.setName(editName);
                    this.company.setAddress(editAddressString);
                    this.company.setLocal(textEditLocal);
                    this.company.setPhoneNum(editTextPhone);

                    AppDatabase.getInstance(this).getCompanyDao().update(this.company);
                    finish();
                }
            }else {
                if (editName.isEmpty() || editAddressString.isEmpty() || textEditLocal.isEmpty() || editTextPhone == 0) {
                    Toast.makeText(this, "Erro, não pode tirar os dados todos da familia!", Toast.LENGTH_LONG).show();
                }else {
                    this.family = AppDatabase.getInstance(this).getFamilyDao().getById(id);

                    this.family.setName(editName);
                    this.family.setAddress(editAddressString);
                    this.family.setLocal(textEditLocal);
                    this.family.setPhoneNum(editTextPhone);

                    AppDatabase.getInstance(this).getFamilyDao().update(this.family);
                    finish();
                }
            }
        }
        catch(Exception e) {
            Log.e(String.valueOf(e), "Error");
        }


    }
}