package com.example.projeto_PAC;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Company.class, Family.class, User.class, Donation.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract CompanyDao getCompanyDao();
    public abstract FamilyDao getFamilyDao();
    public abstract UserDao getUserDao();
    public abstract DonationDao getDonationDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class,
                    "solidaryBankDB")
                    .allowMainThreadQueries()
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            //insert into companies
                            db.execSQL("INSERT INTO Company (codCompany, name, address, local, phoneNum) VALUES (1, 'Continente','Rua das Galias', 'Beja', 234567892)");
                            db.execSQL("INSERT INTO Company (codCompany, name, address, local, phoneNum) VALUES (2, 'Loja da Arminda','Rua da Madeira', 'Beja', 23232323)");
                            db.execSQL("INSERT INTO Company (codCompany, name, address, local, phoneNum) VALUES (3, 'Azeveda','Rua da Banana', 'Lisboa', 111111111)");

                            //insert into families
                            db.execSQL("INSERT INTO Family (codFamily, name, address, local, phoneNum) VALUES (1, 'Casa da Joana','Rua de Albuquerque', 'Lagoa', 2232233)");
                            db.execSQL("INSERT INTO Family (codFamily, name, address, local, phoneNum) VALUES (2, 'Aladins','Rua dos Chuveiros', 'Vila Nova de Gaia', 44345)");
                            db.execSQL("INSERT INTO Family (codFamily, name, address, local, phoneNum) VALUES (3, 'Azevedos','Rua da Banana', 'Lisboa', 111111111)");

                            //insert into user
                            db.execSQL("INSERT INTO User (codUser, userName, password, local) VALUES (1, 'admin', 'admin', 'teste')");
                            db.execSQL("INSERT INTO User (codUser, userName, password, local) VALUES (2, 'monitor', 'monitor', 'teste')");
                            db.execSQL("INSERT INTO User (codUser, userName, password, local) VALUES (3, 'user', 'user', 'teste')");


                            //insert into donations
                            db.execSQL("INSERT INTO Donation (codDonation, amount, codCompany, codFamily, flg_Pendente) VALUES (1, 2000, 1, 1, 0)");
                            db.execSQL("INSERT INTO Donation (codDonation, amount, codCompany, codFamily, flg_Pendente) VALUES (2, 4000, 1, 2, 1)");


                        }
                    })
                    .build();
        }
        return INSTANCE;
    }
}
