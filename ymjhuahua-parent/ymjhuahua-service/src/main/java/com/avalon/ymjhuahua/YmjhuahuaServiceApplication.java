package com.avalon.ymjhuahua;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class YmjhuahuaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(YmjhuahuaServiceApplication.class, args);
    }
}
