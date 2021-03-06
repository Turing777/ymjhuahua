package com.avalon.ymjhuahua;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableAutoConfiguration
@EnableEurekaClient
@EnableConfigServer
@RefreshScope
@SpringBootApplication
public class YmjhuahuaConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(YmjhuahuaConfigApplication.class, args);
    }
}
