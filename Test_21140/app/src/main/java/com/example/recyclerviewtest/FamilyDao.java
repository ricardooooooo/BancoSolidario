package com.example.recyclerviewtest;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface FamilyDao {

    @Query("SELECT * FROM Family")
    List<Company> getAll();

    @Query("SELECT * FROM Family WHERE codFamily = :codFamily")
    Family getById(long codFamily);

    @Insert
    void add(Family family);

    @Insert
    void add(List<Family> families);

    @Delete
    void delete(Family family);

    @Update
    void update(Family family);
}
