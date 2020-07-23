package com.evan.payment.service;


import entities.Payment;

import java.util.List;

public interface PaymentService {

    public int create(Payment payment);

    public List<Payment> getPaymentList(Payment payment);

    public Payment getPaymentById( Long id);

}
