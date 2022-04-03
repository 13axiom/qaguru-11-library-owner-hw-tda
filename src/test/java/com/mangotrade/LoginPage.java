package com.mangotrade;


import com.codeborne.selenide.SelenideElement;
import com.mangotrade.config.Project;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class LoginPage extends TestBase {

    SelenideElement formHeader = $(".css-1ffs9d1.e131aulr0");

    @Test
    @Feature("Login page design")
    @Description("Login test")
    @DisplayName("Login form has form header 'Log In'")
    void checkLoginFormHeader() {
        step("Open url 'https://trade.mangotrade.com/en/login'", () ->
                open("/en/login"));
        System.out.println(Project.projectConfig.webUrl());
        System.out.println(Project.projectConfig.browserSize());
        System.out.println(Project.projectConfig.browserVersion());
        System.out.println(Project.projectConfig.browser());
        sleep(5000);
        step("Check login header form", () -> {
            step("Check form header -> should be 'Log In'", () -> {
                formHeader.shouldHave(exactText("Log In"));
            });
        });
    }

}