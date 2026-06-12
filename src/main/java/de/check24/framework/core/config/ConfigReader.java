package de.check24.framework.core.config;

import org.aeonbits.owner.ConfigFactory;

public final class ConfigReader {
    public static final FrameworkConfig CONFIG =
            ConfigFactory.create(
                    FrameworkConfig.class,
                    System.getProperties(),
                    System.getenv()
            );
    private ConfigReader() {}

}
