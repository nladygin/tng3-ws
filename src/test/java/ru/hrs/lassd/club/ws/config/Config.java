package ru.hrs.lassd.club.ws.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("ru.hrs.lassd.club.ws.*")
@PropertySource({"config.properties"})
public class Config {

    public Config(){}
}
