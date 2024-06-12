package core.config;

import org.aeonbits.owner.Config;


@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "file:src/test/resources/configs/web.properties",
        "file:src/test/resources/configs/common.properties",
})

public interface WebConfig extends Config {

    @DefaultValue("chrome")
    @Key("browser")
    String browser();

    @DefaultValue("1920x1080")
    @Key("browserSize")
    String browserSize();

    @DefaultValue("124")
    @Key("browserVersion")
    String browserVersion();

    @DefaultValue("https://www.invitro.ru")
    @Key("invitroUrl")
    String invitroUrl();
}
