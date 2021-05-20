package com.example.recyclerviewtest;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Family extends BaseDataClass {
    @PrimaryKey(autoGenerate = true)
    private int codFamily;
    private String name;
    private String address;
    private String local;
    private int phoneNum;

    public Family(int codFamily, String name, String address, String local, int phoneNum) {
        this.codFamily = codFamily;
        this.name = name;
        this.address = address;
        this.local = local;
        this.phoneNum = phoneNum;
    }

    @Override
    public int getId() {
        return this.getCodFamily();
    }

    public int getCodFamily() {
        return codFamily;
    }

    public void setCodFamily(int codFamily) {
        this.codFamily = codFamily;
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

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }
}
