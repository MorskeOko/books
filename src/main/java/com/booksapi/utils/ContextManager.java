package com.booksapi.utils;

public class ContextManager {
    private static final ThreadLocal<ScenarioContext> threadLocalContext = ThreadLocal.withInitial(ScenarioContext::new);

    public static ScenarioContext getContext() {
        return threadLocalContext.get();
    }

    public static void cleanUp() {
        threadLocalContext.remove();
    }
}