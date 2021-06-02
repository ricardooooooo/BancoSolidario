package com.example.projeto_PAC;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    private int codUser;
    private String userName;
    private String password;
    private String local;

    public User(int codUser, String userName, String password, String local) {
        this.codUser = codUser;
        this.userName = userName;
        this.password = password;
        this.local = local;
    }

    @Ignore
    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    public int getCodUser() {
        return codUser;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getLocal() {
        return local;
    }
}


