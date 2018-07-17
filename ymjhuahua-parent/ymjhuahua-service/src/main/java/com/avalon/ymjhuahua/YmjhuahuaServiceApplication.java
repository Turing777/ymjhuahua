package com.avalon.ymjhuahua;

import com.avalon.ymjhuahuastarter.ymjhuahuastarter.MyStartupRunner;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
@ComponentScan(basePackages = "com.avalon")
@MapperScan("com.avalon.ymjhuahua.mapper")
public class YmjhuahuaServiceApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public MyStartupRunner startupRunner() {
        return new MyStartupRunner();
    }

    public static void main(String[] args) {
        SpringApplication.run(YmjhuahuaServiceApplication.class, args);
    }
}
