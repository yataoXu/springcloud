package com.evan.service;

import entities.Result;
import org.springframework.stereotype.Component;

/**
 * @Author evan
 * @Since 2020/3/11 22:40
 */
@Component
public class PaymentFallbackService implements Payservice {
    @Override
    public Result getPayment(Long id) {
        return new Result(404, "----PaymentFallbackService fall back paymentInfo_OK,o(╥﹏╥)o", null);
    }

    @Override
    public String paymentFeignTimeout(Long id) {
        return "----PaymentFallbackService fall back paymentInfo_Timeout,o(╥﹏╥)o";
    }
}
