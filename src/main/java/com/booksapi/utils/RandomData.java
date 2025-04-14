package com.booksapi.utils;

import java.security.SecureRandom;

public class RandomData {
    private RandomData() {
        throw new IllegalStateException("Utility class");
    }

    public static String randomString(int length, boolean letters, boolean numbers) {
        String characterPool = "";
        if (letters) {
            characterPool += "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        }
        if (numbers) {
            characterPool += "0123456789";
        }

        if (characterPool.isEmpty()) {
            throw new IllegalArgumentException("Either letters or numbers must be true.");
        }
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder result = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = secureRandom.nextInt(characterPool.length());
            result.append(characterPool.charAt(index));
        }
        return result.toString();
    }
}