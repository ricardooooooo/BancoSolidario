package com.example.recyclerviewtest;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    private static List<Company> companyList;

    private DataSource() {

    }

    public static List<Company> getCompanyList() {
      /*  if (companyList == null) {
            companyList = new ArrayList<>();
            companyList.add(new Company(1,"Continente","Rua das Galias","Beja",234567892));
            companyList.add(new Company(2, "Loja da Arminda","Rua da Madeira","Beja",23232323));
            companyList.add(new Company(3,"Azeveda","rua da banana","Lisboa",111111111));

        }
        return companyList;*/
        return AppDatabase.getInstance(context).getCompanyDao().getById(id);
    }

    public static Company getCompany(int position) {
        return getCompanyList().get(position);
    }
}
