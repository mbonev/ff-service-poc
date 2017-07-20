package com.example.fulfillment.integration.ams.infrastructure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * Created by luchob on 7/20/17.
 */

/**
 * Describes the configuration for basic authentication.
 */
@Validated
@ConfigurationProperties(prefix="ams")
public class BasicAuthConfiguration {

    @NotNull
    private String userName;
    @NotNull
    private String userPassword;

    /**
     * Returns the user name for the basic authentication.
     *
     * @return  user name for the basic authentication.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Returns the user name for the basic authentication.
     *
     * @param userName the user name for the basic auth.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * The password for basic authentication.
     *
     * @return the password for basic authentication.
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * The user password for the basic auth.
     *
     * @param userPassword the user password for the basic auth.
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
