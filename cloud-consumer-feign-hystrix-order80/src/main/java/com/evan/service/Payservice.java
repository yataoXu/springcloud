package com.evan.service;

import entities.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE", fallback = PaymentFallbackService.class)
public interface Payservice {

    @GetMapping("/payment/{id}")
    Result getPayment(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout/{id}")
    String paymentFeignTimeout(@PathVariable("id") Long id);
}
