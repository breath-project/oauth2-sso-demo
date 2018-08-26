package com.undancer.message.config;

import org.apache.catalina.filters.RequestDumperFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class FilterConfig {

    @Profile("!cloud")
    @Bean
    RequestDumperFilter requestDumperFilter() {
        return new RequestDumperFilter();
    }

}
