package com.example.recycler;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Company.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract CompanyDao getCountryDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class,
                    "companyDB")
                    .allowMainThreadQueries()
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            db.execSQL("INSERT INTO Company (name, flag) VALUES ('Austria', 'https://europa.eu/european-union/sites/europaeu/files/country_images/flags/flag-austria.jpg')");
                            db.execSQL("INSERT INTO Company (name, flag) VALUES ('Belgium', 'https://europa.eu/european-union/sites/europaeu/files/country_images/flags/flag-belgium.jpg')");
                            db.execSQL("INSERT INTO Company (name, flag) VALUES ('Bulgaria', 'https://europa.eu/european-union/sites/europaeu/files/country_images/flags/flag-bulgaria.jpg')");
                            db.execSQL("INSERT INTO Company (name, flag) VALUES ('Croatia', 'https://europa.eu/european-union/sites/europaeu/files/country_images/flags/flag-croatia.jpg')");
                        }
                    })
                    .build();
        }
        return INSTANCE;
    }
}
