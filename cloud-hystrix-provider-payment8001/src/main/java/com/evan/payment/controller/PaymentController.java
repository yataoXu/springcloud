package com.evan.payment.controller;


import com.evan.payment.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import entities.Payment;
import entities.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @ClassName PaymentController
 * @Author Evan
 * @date 2020.06.06 00:32
 */

@Slf4j
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private PaymentService paymentService;


    @GetMapping("/payment/{id}")
    public Result getPayment(@PathVariable("id") Long id) {
        Payment paymentById = paymentService.getPaymentById(id);

        if (paymentById != null) {
            log.info("查询成功: port:{},result:{}", port, paymentById);
            return new Result(200, "查询成功" + port, paymentById);
        } else {
            log.info("查询失败: port:{},result:{}", port, null);
            return new Result(444, "查询失败", null);
        }
    }

    @GetMapping(value = "/payment/feign/timeout/{id}")
    public String paymentHystrixTimeout(Long id) {
        return paymentService.paymentInfo_Timeout(id);
    }

    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("*****result: " + result);
        return result;
    }



}
