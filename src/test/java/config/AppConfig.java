package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/app.properties"})
public interface AppConfig extends Config{

    String urlBrowserstack();
    String userName();
    String password();
    String browserstackSessions();
}
