package com.example.projeto_PAC;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

        @Query("SELECT * FROM User")
        List<User> getAll();

        @Query("SELECT * FROM User WHERE id = :id")
        User getById(long id);

        @Query("SELECT * FROM User WHERE userName = :name & password = :password")
        User getByText(String name, String password);

        @Insert
        void add(User user);

        @Insert
        void add(List<User> userList);

        @Delete
        void delete(User user);

        @Update
        void update(User user);
}

