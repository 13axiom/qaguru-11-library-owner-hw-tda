package com.mangotrade;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.mangotrade.config.Project;
import com.mangotrade.config.ProjectConfig;
import com.mangotrade.helpers.AllureAttachments;
import com.mangotrade.helpers.DriverSettings;
import com.mangotrade.helpers.DriverUtils;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


@ExtendWith({AllureJunit5.class})
public class TestBase {

   @BeforeAll
   public static void setUp() {
       SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
       DriverSettings.configure();

   }


    @AfterEach
    public void addAttachments() {
        String sessionId = DriverUtils.getSessionId();

        AllureAttachments.addScreenshotAs("Last screenshot");
        AllureAttachments.addPageSource();
        AllureAttachments.addBrowserConsoleLogs();

        Selenide.closeWebDriver();

        if (Project.isVideoOn()) {
            AllureAttachments.addVideo(sessionId);
        }
    }
}
