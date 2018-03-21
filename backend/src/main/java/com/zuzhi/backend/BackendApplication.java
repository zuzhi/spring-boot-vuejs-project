package com.zuzhi.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * SpringBootVuejsProjectApplication
 *
 * @author zuzhi
 * @date 13/03/2018
 */
@SpringBootApplication
@EnableEurekaClient
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }
}
