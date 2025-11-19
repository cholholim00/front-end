package com.example.secret_diary;


import android.content.Context;
import android.content.SharedPreferences;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DiaryStore {
    private static final String PREF = "diary_pref";
    private static final String KEY = "items";


    public static List<DiaryItem> load(Context ctx){
        SharedPreferences sp = ctx.getSharedPreferences(PREF, Context.MODE_PRIVATE);
        String json = sp.getString(KEY, "[]");
        Type type = new TypeToken<ArrayList<DiaryItem>>(){}.getType();
        List<DiaryItem> list = new Gson().fromJson(json, type);
        return list != null ? list : new ArrayList<>();
    }


    public static void save(Context ctx, List<DiaryItem> list){
        SharedPreferences sp = ctx.getSharedPreferences(PREF, Context.MODE_PRIVATE);
        sp.edit().putString(KEY, new Gson().toJson(list)).apply();
    }


    public static void sortByDateDesc(List<DiaryItem> list){
        Collections.sort(list, (a,b) -> Long.compare(b.dateMillis, a.dateMillis));
    }


    public static void sortByDateAsc(List<DiaryItem> list){
        Collections.sort(list, (a,b) -> Long.compare(a.dateMillis, b.dateMillis));
    }
}