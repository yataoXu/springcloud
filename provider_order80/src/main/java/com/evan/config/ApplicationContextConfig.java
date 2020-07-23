package com.evan.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @ClassName applicationContext
 * @Author Evan
 * @date 2020.06.06 18:05
 */

@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced
    public RestTemplate  getRestTemplate() {
        return new RestTemplate();
    }

}
