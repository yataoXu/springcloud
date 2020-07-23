package com.evan.payment.service;


import entities.Payment;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface PaymentService {

    public int create(Payment payment);

    public List<Payment> getPaymentList(Payment payment);

    public Payment getPaymentById(Long id);

    public String paymentInfo_Timeout(Long id);

    public String paymentCircuitBreaker(@PathVariable("id") Integer id);
}
