package com.booksapi.services.utils;

import com.booksapi.configurations.TestConfig;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiDefaultMethod {

    public static final TestConfig testConfig = new TestConfig();

    private ApiDefaultMethod() {
        throw new IllegalStateException("Utility class");
    }

    public static void post(String endpoint, Object model) {
        given()
                .auth().preemptive().basic(testConfig.getApiUser(), testConfig.getApiPass())
                .body(model)
                .when()
                .post(endpoint)
                .then()
                .statusCode(200);
    }

    public static ValidatableResponse postWithResponse(String endpoint, Object model) {
        return given()
                .auth().preemptive().basic(testConfig.getApiUser(), testConfig.getApiPass())
                .body(model)
                .when()
                .post(endpoint)
                .then()
                .statusCode(200);
    }

    public static <T> T postWithExtract(String endpoint, Object model, Class<T> clazz) {
        return given()
                .auth().preemptive().basic(testConfig.getApiUser(), testConfig.getApiPass())
                .body(model)
                .when()
                .post(endpoint)
                .then()
                .statusCode(200)
                .extract()
                .as(clazz);
    }

    public static <T> T postWithExtractAndNoCode(String endpoint, Object model, Class<T> clazz) {
        return given()
                .auth().preemptive().basic(testConfig.getApiUser(), testConfig.getApiPass())
                .body(model)
                .when()
                .post(endpoint)
                .then()
                .extract()
                .as(clazz);
    }

    public static ValidatableResponse postWithPathParams(String endpoint, Object model, Map<String, ?> paramsMap) {
        return given()
                .auth().preemptive().basic(testConfig.getApiUser(), testConfig.getApiPass())
                .pathParams(paramsMap)
                .body(model)
                .when()
                .post(endpoint)
                .then()
                .statusCode(200);
    }

    public static <T> T postExtractWithPathParams(String endpoint,
                                                  Object model,
                                                  Map<String, ?> paramsMap,
                                                  Class<T> clazz) {
        return given()
                .auth().preemptive().basic(testConfig.getApiUser(), testConfig.getApiPass())
                .pathParams(paramsMap)
                .body(model)
                .when()
                .post(endpoint)
                .then()
                .statusCode(200)
                .extract()
                .as(clazz);
    }

    public static <T> T get(String endpoint, Class<T> clazz) {
        return given()
                .auth().preemptive().basic(testConfig.getApiUser(), testConfig.getApiPass())
                .when()
                .get(endpoint)
                .then()
                .statusCode(200)
                .extract()
                .as(clazz);
    }

    public static Response get(String endpoint) {
        return given()
                .auth().preemptive().basic(testConfig.getApiUser(), testConfig.getApiPass())
                .when()
                .get(testConfig.getBaseUrl() + endpoint);
    }

    public static Response deleteById(String endpoint, int id) {
        return given()
                .auth().preemptive().basic(testConfig.getApiUser(), testConfig.getApiPass())
                .when()
                .delete(testConfig.getBaseUrl() + endpoint + id);
    }

    public static Response getById(String endpoint, int id) {
        return given()
                .auth().preemptive().basic(testConfig.getApiUser(), testConfig.getApiPass())
                .when()
                .get(testConfig.getBaseUrl() + endpoint + id);
    }

    public static <T> List<T> getAsList(String endpoint, Class<T> clazz) {
        return given()
                .auth().preemptive().basic(testConfig.getApiUser(), testConfig.getApiPass())
                .when()
                .get(endpoint)
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getList(".", clazz);
    }

    public static void delete(String endpoint, Object id) {
        given()
                .auth().preemptive().basic(testConfig.getApiUser(), testConfig.getApiPass())
                .when()
                .delete(endpoint, id)
                .then()
                .statusCode(200);
    }

    public static ValidatableResponse deleteWithResponse(String endpoint, Object id) {
        return given()
                .auth().preemptive().basic(testConfig.getApiUser(), testConfig.getApiPass())
                .when()
                .delete(endpoint, id)
                .then()
                .statusCode(200);
    }
}