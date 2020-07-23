package com.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @ClassName MyselfRule
 * @Author Evan
 * @date 2020.06.07 22:06
 */

@Configuration
public class MyselfRule {

    @Bean
    public IRule myRule(){
        // 随机
        return new RandomRule();
    }
}
