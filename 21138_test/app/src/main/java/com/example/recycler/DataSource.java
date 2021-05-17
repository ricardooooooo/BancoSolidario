package com.example.recycler;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    private static List<Company> companyList;

    private DataSource() {

    }

    public static List<Company> getCompanyList(Context context) {
        return AppDatabase.getInstance(context).getCompanyDao().getAll();
    }

    public static Company getCompany(Context context, long id) {
        return AppDatabase.getInstance(context).getCompanyDao().getById(id);
    }
}
