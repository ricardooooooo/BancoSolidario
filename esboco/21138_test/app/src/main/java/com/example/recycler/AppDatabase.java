package com.example.recycler;

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
                    "companyDB")
                    .allowMainThreadQueries()
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            db.execSQL("INSERT INTO Company (name, adress, local, phoneNumber) VALUES ('Continente', 'R. Zeca Afonso, 7800-522 Beja', 'Beja', '214182183')");
                             db.execSQL("INSERT INTO Company (name, adress, local, phoneNumber) VALUES ('Intermache', 'Av. Fialho de Almeida n78, 7800-395 Beja', 'Beja', '9314818318')");
                            db.execSQL("INSERT INTO Company (name, adress, local, phoneNumber) VALUES ('Minipreco', 'Av. Gago Coutinho 3, 7900-110 Ferreira do Alentejo', 'Ferreira', '934593191')");
                        }
                    })
                    .build();
        }
        return INSTANCE;
    }
}
