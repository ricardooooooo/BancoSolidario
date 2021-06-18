package com.example.projeto_PAC;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Company extends BaseDataClass {
    @PrimaryKey(autoGenerate = true)
    private long codCompany;
    private String name;
    private String address;
    private String local;
    private int phoneNum;

    public Company(long codCompany,String name, String address, String local, int phoneNum) {
        this.codCompany = codCompany;
        this.name = name;
        this.address = address;
        this.local = local;
        this.phoneNum = phoneNum;
    }

    @Override
    public long getId() {
        return getCodCompany();
    }

    public long getCodCompany() {
        return codCompany;
    }

    public void setCodCompany(long codCompany) {
        this.codCompany = codCompany;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    @Override
    public String getType() {
        return BaseDataClass.TYPE_COMPANY;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }
}