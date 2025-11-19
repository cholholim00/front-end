package com.example.secret_diary;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;


public class Utils {
    public static String fmt(long millis){
        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(millis));
    }
    public static String id(){ return UUID.randomUUID().toString(); }
}