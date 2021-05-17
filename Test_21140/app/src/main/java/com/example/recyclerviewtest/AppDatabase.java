package com.example.recyclerviewtest;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Company.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract CompanyDao getCompanyDao();

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
                            db.execSQL("INSERT INTO Company (codCompany, name, address, local, phoneNum) VALUES (1, 'Continente','Rua das Galias', 'Beja', 234567892)");
                            db.execSQL("INSERT INTO Company (codCompany, name, address, local, phoneNum) VALUES (2, 'Loja da Arminda','Rua da Madeira', 'Beja', 23232323)");
                            db.execSQL("INSERT INTO Company (codCompany, name, address, local, phoneNum) VALUES (3, 'Azeveda','Rua da Banana', 'Lisboa', 111111111)");
                        }
                    })
                    .build();
        }
        return INSTANCE;
    }


}
