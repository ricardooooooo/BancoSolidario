package com.example.recyclerviewtest;

public class Family {
    private int codFamily;
    private String name;
    private String adress;
    private String local;
    private int phoneNum;

    public Family(int codFamily, String name, String adress, String local, int phoneNum) {
        this.codFamily = codFamily;
        this.name = name;
        this.adress = adress;
        this.local = local;
        this.phoneNum = phoneNum;
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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
