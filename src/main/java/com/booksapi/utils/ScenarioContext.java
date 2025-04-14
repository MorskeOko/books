package com.booksapi.utils;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private final Map<String, Object> data = new HashMap<>();

    public void set(String key, Object value) {
        data.put(key, value);
    }

    public <T> T get(String key, Class<T> clazz) {
        return clazz.cast(data.get(key));
    }

    public <T> T getOrDefault(String key, T defaultValue) {
        Object value = data.get(key);
        return value != null ? (T) value : defaultValue;
    }

    public boolean contains(String key) {
        return data.containsKey(key);
    }
}