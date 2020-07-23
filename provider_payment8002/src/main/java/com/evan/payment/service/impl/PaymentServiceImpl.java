package com.evan.payment.service.impl;

import com.evan.payment.dao.PaymentDao;
import com.evan.payment.service.PaymentService;
import entities.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @ClassName PaymentServiceImpl
 * @Author Evan
 * @date 2020.06.06 00:00
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;


    @Override
    public int create(Payment payment) {


        return paymentDao.create(payment);
    }

    @Override
    public List<Payment> getPaymentList(Payment payment) {
        return null;
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
