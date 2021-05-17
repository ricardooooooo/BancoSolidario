package com.example.recyclerviewtest;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CompanyDao {

    @Query("SELECT * FROM Company")
    List<Company> getAll();

    @Query("SELECT * FROM Company WHERE codCompany = :codCompany")
    Company getById(long codCompany);

    @Insert
    void add(Company country);

    @Insert
    void add(List<Company> companies);

    @Delete
    void delete(Company company);

    @Update
    void update(Company company);
}
