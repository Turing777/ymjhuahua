package com.avalon.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class YmjhuahuaCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(YmjhuahuaCacheApplication.class, args);
    }
}
