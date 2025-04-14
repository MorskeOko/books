@echo off
chcp 65001 > nul
echo 🔥 Running SMOKE tests...
call gradlew clean test --tests com.booksapi.runner.TestRunnerSmoke
allure serve build\allure-results-smoke