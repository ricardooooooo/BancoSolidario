package com.example.projeto_PAC;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {

    private SessionManager() {}

    private static SharedPreferences sharedPreferences;
    private static final String FILENAME = "sessionSharedPrefs";
    private static final String KEY_USER_CODE = "userCode";

    private static SharedPreferences getSharedPreferences(Context context) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getApplicationContext().getSharedPreferences(FILENAME, Context.MODE_PRIVATE);
        }
        return sharedPreferences;
    }

    public static void login(Context context, int codUser) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putInt(KEY_USER_CODE, codUser);


        editor.apply();
    }

    public static void logout(Context context) {
        getSharedPreferences(context).edit().clear().apply();
    }

    public static int getActiveSession(Context context) {
        if (getSharedPreferences(context).contains(KEY_USER_CODE)) {
            return getSharedPreferences(context).getInt(KEY_USER_CODE, -1);
        }
        return -1;
    }
}
