package com.mangotrade;


import com.mangotrade.config.ApiConfig;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.aeonbits.owner.ConfigFactory;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class ApiTests {

    @Test
    @DisplayName("assertj api token/url test")
    void apiTokenTest() {
        ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class, System.getProperties());
        String er = System.getProperty("er");
        switch (er) {
            case "local":
                assertThat(apiConfig.apiToken()).isEqualTo("new_token");
                assertThat(apiConfig.apiBaseUrl()).isEqualTo("https://api.link.com");
            case "remote":
                assertThat(apiConfig.apiToken()).isEqualTo("remote_token");
                assertThat(apiConfig.apiBaseUrl()).isEqualTo("https://api.link.com");
        }
    }
}