package de.check24.framework.core.config;

import de.check24.framework.core.enums.BrowserType;
import org.aeonbits.owner.Config;

@Config.Sources("classpath:application.properties")
public interface FrameworkConfig extends Config {
    @Key("browser")
    @DefaultValue("CHROME")
    BrowserType browser();

    @Key("headless")
    @DefaultValue("false")
    boolean headless();

    @Key("timeout")
    @DefaultValue("10")
    int timeout();

    @Key("baseUrl")
    @DefaultValue("https://www.check24.de")
    String baseUrl();
}