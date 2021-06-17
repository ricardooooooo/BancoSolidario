package com.example.projeto_PAC;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface FamilyDao {

    @Query("SELECT * FROM Family")
    List<Family> getAll();

    @Query("SELECT * FROM Family WHERE codFamily = :codFamily")
    Family getById(long codFamily);

    @Query("SELECT * FROM Family WHERE name LIKE :search || '%'")
    List<Family> getAllByText(String search);

    @Insert
    void add(Family family);

    @Insert
    void add(List<Family> families);

    @Delete
    void delete(Family family);

    @Update
    void update(Family family);
}
