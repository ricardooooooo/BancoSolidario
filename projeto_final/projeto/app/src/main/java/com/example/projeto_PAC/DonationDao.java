package com.example.projeto_PAC;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DonationDao {
    @Query("SELECT * FROM Donation")
    List<Donation> getAll();

    @Query("SELECT * FROM Donation WHERE codDonation = :codDonation")
    Donation getById(long codDonation);

    @Query("SELECT * FROM Donation WHERE flg_Pendente = 1")
    List<Donation> getAutorizado();

    @Query("SELECT * FROM Donation WHERE flg_Pendente = 1")
    List<Donation> getNaoAutorizado();

    @Insert
    void add(Donation donation);

    @Delete
    void delete(Donation donation);

    @Update
    void update(Donation donation);
}
