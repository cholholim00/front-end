package com.example.secret_diary;

import java.io.Serializable;

public class DiaryItem implements Serializable {
    public String id;
    public String title;
    public String content;
    public long dateMillis;
    public boolean secret;

    public DiaryItem(String id, String title, String content, long dateMillis, boolean secret) {
        this.id = id; this.title = title; this.content = content; this.dateMillis = dateMillis; this.secret = secret;
    }
}
