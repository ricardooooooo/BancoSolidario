package com.example.projeto_PAC;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    private int codUser;
    private String userName;
    private String password;
    private String local;

    public User(int id, String userName, String password, String local) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.local = local;
    }

    public int getId() {
        return id;
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


