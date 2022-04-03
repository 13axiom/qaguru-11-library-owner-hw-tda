package com.mangotrade.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/local.properties")
public interface ProjectConfig extends Config{

    @Key("browserMobileView")
    @DefaultValue("")
    String browserMobileView();

    @Key("remoteDriverUrl")
    @DefaultValue("")
    String remoteDriverUrl();

    @Key("videoStorage")
    @DefaultValue("")
    String videoStorage();

    @Key("baseurl")
    @DefaultValue("https://trade.mangotrade.com")
    String webUrl();

    @Key("browser")
    String browser();

    @Key("browser.size")
    String browserSize();

    @Key("brovser.version")
    String browserVersion();

}
