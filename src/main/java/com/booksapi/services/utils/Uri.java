package com.booksapi.services.utils;

import com.booksapi.configurations.TestConfig;

public class Uri {
    private static final String BASE_URL = new TestConfig().getBaseUrl();

    public static final String BOOKS = BASE_URL + "/books";

    private Uri() {
        throw new IllegalStateException("Utility class");
    }
}