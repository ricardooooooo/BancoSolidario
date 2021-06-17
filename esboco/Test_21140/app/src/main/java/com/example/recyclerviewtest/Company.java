package com.example.recyclerviewtest;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Company extends BaseDataClass {
    @PrimaryKey(autoGenerate = true)
    private int codCompany;
    private String name;
    private String address;
    private String local;
    private int phoneNum;

    public Company(int codCompany,String name, String address, String local, int phoneNum) {
        this.codCompany = codCompany;
        this.name = name;
        this.address = address;
        this.local = local;
        this.phoneNum = phoneNum;
    }

    @Override
    public int getId() {
        return this.getCodCompany();
    }

    public int getCodCompany() {
        return codCompany;
    }

    public void setCodCompany(int codCompany) {
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
