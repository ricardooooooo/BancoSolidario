package com.example.recyclerviewtest;

public abstract class BaseDataClass {

    public static final String TYPE_FAMILY = "Family";
    public static final String TYPE_COMPANY = "Company";

    public abstract int getId();
    public abstract String getName();
    public abstract String getAddress();
    public abstract String getLocal();
    public abstract int getPhoneNum();
    public abstract String getType();

}
