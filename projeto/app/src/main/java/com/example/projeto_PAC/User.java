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
    private String type_User;

    public User(int codUser, String userName, String password, String local, String type_User) {
        this.codUser = codUser;
        this.userName = userName;
        this.password = password;
        this.local = local;
        this.type_User = type_User;
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

    public String getType_User() {
        return type_User;
    }

    public void setType_User(String type_User) {
        this.type_User = type_User;
    }
}


