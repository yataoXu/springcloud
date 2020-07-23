package com.evan.controller;

import com.evan.service.Payservice;
import entities.Payment;
import entities.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author Evan
 * @date 2020.06.06 00:32
 */

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private Payservice payservice;

    @GetMapping("/consumer/payment/get/{id}")
    public Result<Payment> getPayment(@PathVariable("id") Long id) {
        return payservice.getPayment(id);
    }
    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout() {
        //openfeign-ribbon 客户端默认等待1S
        return  payservice.paymentFeignTimeout();
    }
}
