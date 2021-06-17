package com.example.recycler;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Company {
        @PrimaryKey(autoGenerate = true)
        private int id;
        private String name;
        private String adress;
        private String local;
        private int phoneNumber;

        public Company(int id, String name, String adress, String local, int phoneNumber) {
            this.id = id;
            this.name = name;
            this.adress = adress;
            this.local = local;
            this.phoneNumber = phoneNumber;
        }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public String getLocal() {
        return local;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
