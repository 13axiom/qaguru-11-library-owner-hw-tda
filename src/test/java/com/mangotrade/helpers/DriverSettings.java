package com.mangotrade.helpers;

import com.codeborne.selenide.Configuration;
import com.mangotrade.config.Project;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

public class DriverSettings {

    public static void configure() {
        //System.setProperty("url","mango");//todo работает отсюда, но из консоли не позволяет менять проперти файл, че за нах?
        //System.getProperty("url","mango");
       // System.setProperty("url",System.getProperty("url","mango"));

        //System.getProperty("properties", "local");
        Configuration.browser = Project.projectConfig.browser();
        Configuration.browserVersion = Project.projectConfig.browserVersion();
        Configuration.browserSize = Project.projectConfig.browserSize();

        Configuration.baseUrl = Project.projectConfig.webUrl();

        DesiredCapabilities capabilities = new DesiredCapabilities();
            ChromeOptions chromeOptions = new ChromeOptions();

            chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--lang=en-en");

        if (Project.isRemoteWebDriver()) {
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.remote = Project.projectConfig.remoteDriverUrl();
        }

        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        Configuration.browserCapabilities = capabilities;
    }
}
