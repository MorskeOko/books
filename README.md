# books
Books API test automation



This repository contains an automated test suite for verifying the functionality of a sample Books API. 
The project includes regression and smoke test scenarios, supports parallel execution.



* Stack:


Java 17 - Programming language

Gradle - Build tool

JUnit 5 - Test engine for parallel execution

Cucumber BDD - Gherkin-based feature specification

REST Assured - API testing library

AssertJ - Fluent assertions

Allure - Reporting

Lombok - Boilerplate elimination

OWNER - Config management


* How to run tests

First you need to set base URL, user name and pass to the environment properties file.
They are currently replaced by placeholders to protect sensitive data.

* Smoke tests

execute file in root that names run-smoke-suit-with-allure-report.bat

This will:

1. Run all scenarios tagged with @smoke,
2. Generate an Allure report in build/allure-results-smoke
3. Open the report in your browser

* Regression tests
execute file in root that names run-regression-suit-with-allure-report.bat
  This will:

1. Run all scenarios tagged with @regression,
2. Generate an Allure report in build/allure-results-smoke
3. Open the report in your browser


Parallel execution is enabled via JUnit 5 and junit-platform.properties.

Allure results are automatically generated per suite.