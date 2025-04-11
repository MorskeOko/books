package com.booksapi.configurations;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.Sources;

/**
 * Contains the credentials.
 * The credentials are loaded from environment variables.
 */
@LoadPolicy(Config.LoadType.MERGE)
@Sources({"system:env", "system:properties", "classpath:environment.properties"})
public interface CredentialsConfig extends Config {

    @Key("api.user")
    String apiUserName();

    @Key("api.pass")
    String apiUserPass();

    @Key("baseUrl")
    String baseUrl();
}