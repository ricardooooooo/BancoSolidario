package com.example.projeto_PAC;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Donation {
    @PrimaryKey(autoGenerate = true)
    int codDonation;
    int codCompany;
    int codFamily;
    int ammount;

    public Donation(int codDonation, int codCompany, int codFamily, int ammount) {
        this.codDonation = codDonation;
        this.codCompany = codCompany;
        this.codFamily = codFamily;
        this.ammount = ammount;
    }

    public int getCodDonation() {
        return codDonation;
    }

    public void setCodDonation(int codDonation) {
        this.codDonation = codDonation;
    }

    public int getCodCompany() {
        return codCompany;
    }

    public void setCodCompany(int codCompany) {
        this.codCompany = codCompany;
    }

    public int getCodFamily() {
        return codFamily;
    }

    public void setCodFamily(int codFamily) {
        this.codFamily = codFamily;
    }

    public int getAmmount() {
        return ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }


}
