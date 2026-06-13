package com.example;


public class GugudanBean_2024201019 {
    private int dan;
    private String fontColor;
    private String fontSize;

    public int getDan() {
        return dan;
    }

    public void setDan(int dan) {
        this.dan = dan;
    }

    public String getFontColor() {
        return fontColor;
    }

    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    public String getFontSize() {
        return fontSize;
    }

    public void setFontSize(String fontSize) {
        this.fontSize = fontSize;
    }

    public String generateGugudan() {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= 9; i++) {
            result.append(dan).append(" x ").append(i).append(" = ").append(dan * i).append("<br>");
        }
        return result.toString();
    }
}