package com.avalon.testclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class TestClient1Application {

    public static void main(String[] args) {
        SpringApplication.run(TestClient1Application.class, args);
    }
}
