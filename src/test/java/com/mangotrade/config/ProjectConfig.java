package com.mangotrade.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/${properties}.properties")
public interface ProjectConfig extends Config{

    @Key("remoteDriverUrl")
    @DefaultValue("")
    String remoteDriverUrl();

    @Key("videoStorage")
    @DefaultValue("")
    String videoStorage();

    @Key("baseurl")
    @DefaultValue("https://trade.capitalbear.com/")
    String webUrl();

    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("browser.size")
    @DefaultValue("3840x2160")
    String browserSize();

    @Key("browser.version")
    @DefaultValue("91.0")
    String browserVersion();

}
