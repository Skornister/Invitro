package core.config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigReader {

    public static final WebConfig webConfig = ConfigFactory.create(WebConfig.class, System.getProperties());
}
