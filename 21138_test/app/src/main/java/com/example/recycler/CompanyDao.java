package com.example.recycler;

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

        @Query("SELECT * FROM Company WHERE name LIKE :search || '%'")
        List<Company> getAllByText(String search);

        @Query("SELECT * FROM Company WHERE id = :id")
        Company getById(long id);

        @Insert
        void add(Company company);

        @Insert
        void add(List<Company> companyList);

        @Delete
        void delete(Company companies);

        @Update
        void update(Company companies);
}
