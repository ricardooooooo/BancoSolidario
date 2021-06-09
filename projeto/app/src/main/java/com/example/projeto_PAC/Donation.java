package com.example.projeto_PAC;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Donation {
    @PrimaryKey(autoGenerate = true)
    long codDonation;
    long codCompany;
    long codFamily;
    int amount;
    boolean flg_Pendente;

    public Donation(long codDonation, long codCompany, long codFamily, int amount, boolean flg_Pendente) {
        this.codDonation = codDonation;
        this.codCompany = codCompany;
        this.codFamily = codFamily;
        this.amount = amount;
        this.flg_Pendente = flg_Pendente;
    }

    public long getCodDonation() {
        return codDonation;
    }

    public void setCodDonation(long codDonation) {
        this.codDonation = codDonation;
    }

    public long getCodCompany() {
        return codCompany;
    }

    public void setCodCompany(long codCompany) {
        this.codCompany = codCompany;
    }

    public long getCodFamily() {
        return codFamily;
    }

    public void setCodFamily(long codFamily) {
        this.codFamily = codFamily;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isFlg_Pendente() {
        return flg_Pendente;
    }

    public void setFlg_Pendente(boolean flg_Pendente) {
        this.flg_Pendente = flg_Pendente;
    }
}
