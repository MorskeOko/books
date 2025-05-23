package com.booksapi.services.utils;

import com.booksapi.configurations.TestConfig;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ApiDefaultMethod {

    private static final TestConfig testConfig = new TestConfig();
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String APPLICATION_JSON = "application/json";

    private ApiDefaultMethod() {
        throw new IllegalStateException("Utility class");
    }

    public static Response get(String endpoint) {
        return given()
                .auth().preemptive().basic(testConfig.getApiUser(), testConfig.getApiPass())
                .when()
                .get(endpoint);
    }

    public static <T> T getById(String endpoint, int id, Class<T> clazz) {
        return given()
                .auth().preemptive().basic(testConfig.getApiUser(), testConfig.getApiPass())
                .when()
                .get(endpoint + "/" + id)
                .then()
                .statusCode(200)
                .extract()
                .as(clazz);
    }

    public static <T> T  postExtractedAsClass(String endpoint, Object model, Class<T> clazz) {
        return given()
                .auth().preemptive().basic(testConfig.getApiUser(), testConfig.getApiPass())
                .header(CONTENT_TYPE, APPLICATION_JSON)
                .body(model)
                .when()
                .post(endpoint)
                .then()
                .statusCode(200)
                .extract()
                .as(clazz);
    }

    public static Response post(String endpoint, Object model) {
        return given()
                .auth().preemptive().basic(testConfig.getApiUser(), testConfig.getApiPass())
                .header(CONTENT_TYPE, APPLICATION_JSON)
                .body(model)
                .when()
                .post(endpoint);
    }

    public static Response put(String endpoint, Object model, int id) {
        return given()
                .auth().preemptive().basic(testConfig.getApiUser(), testConfig.getApiPass())
                .header(CONTENT_TYPE, APPLICATION_JSON)
                .body(model)
                .when()
                .put(endpoint + "/" + id);
    }

    public static Response deleteById(String endpoint, int id) {
        return given()
                .auth().preemptive().basic(testConfig.getApiUser(), testConfig.getApiPass())
                .when()
                .delete(endpoint + "/" + id);
    }

    public static <T> T deleteByIdExtract(String endpoint, int id, Class<T> clazz) {
        return given()
                .auth().preemptive().basic(testConfig.getApiUser(), testConfig.getApiPass())
                .header(CONTENT_TYPE, APPLICATION_JSON)
                .when()
                .delete(endpoint + "/" + id)
                .then()
                .extract()
                .as(clazz);
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
}