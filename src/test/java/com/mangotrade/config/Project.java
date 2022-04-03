package com.mangotrade.config;

import org.aeonbits.owner.ConfigFactory;

public class Project {

        public static ProjectConfig projectConfig = ConfigFactory.create(ProjectConfig.class, System.getProperties());

        public static boolean isWebMobile () {
            return !projectConfig.browserMobileView().equals("");
        }

        public static boolean isRemoteWebDriver () {
            return !projectConfig.remoteDriverUrl().equals("");
        }

        public static boolean isVideoOn () {
            return !projectConfig.videoStorage().equals("");
        }
}
