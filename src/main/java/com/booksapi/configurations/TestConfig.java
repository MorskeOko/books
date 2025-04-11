package com.booksapi.configurations;
import lombok.Getter;
import org.aeonbits.owner.ConfigFactory;

@Getter
public class TestConfig {

    private final CredentialsConfig credentialsConfig = ConfigFactory.create(CredentialsConfig.class);

    private final String baseUrl;
    private final String apiUser;
    private final String apiPass;

    public TestConfig() {
        baseUrl = credentialsConfig.baseUrl();
        apiUser = credentialsConfig.apiUserName();
        apiPass = credentialsConfig.apiUserPass();
    }
}