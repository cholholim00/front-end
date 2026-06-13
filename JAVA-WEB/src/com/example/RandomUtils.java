package com.example;

import java.util.Random;

public class RandomUtils {
    private static final Random random = new Random();

    // 랜덤 색상 생성
    public static String generateRandomColor() {
        return String.format("#%06x", random.nextInt(0xFFFFFF + 1));
    }

    // 랜덤 폰트 크기 생성
    public static String generateRandomFontSize() {
        return String.valueOf(10 + random.nextInt(31)); // 10px ~ 40px
    }
}