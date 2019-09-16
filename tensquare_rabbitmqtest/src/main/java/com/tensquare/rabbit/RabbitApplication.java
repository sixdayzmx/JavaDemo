package com.tensquare.rabbit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class RabbitApplication {
    public static void main(String[] args) {
        SpringApplication.run(RabbitApplication.class);

    }
}
