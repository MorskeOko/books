@echo off
chcp 65001 > nul
echo 🔁 Running REGRESSION tests...
call gradlew clean test --tests com.booksapi.runner.TestRunnerRegression
allure serve build\allure-results-regression