package com.apsooba.interview.config;//package com.apsooba.interview.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@Data
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

    public Url url;

    @Data
    @ConfigurationProperties(prefix = "application.url", ignoreUnknownFields = false)
    public static class Url {
        private String post;
        private String comments;
    }

}
