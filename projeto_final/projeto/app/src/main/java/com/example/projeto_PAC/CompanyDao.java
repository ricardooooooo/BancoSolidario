package com.example.projeto_PAC;

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

    @Query("SELECT * FROM Company WHERE name LIKE :search || '%'")
    List<Company> getAllByText(String search);

    @Insert
    void add(Company country);

    @Insert
    void add(List<Company> companies);

    @Delete
    void delete(Company company);

    @Update
    void update(Company company);
}
