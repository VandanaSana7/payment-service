package com.payment.in.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.in.entity.Payment;
import com.payment.in.entity.PaymentStatus;
import com.payment.in.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService{


    private PaymentRepository paymentRepository;

    @Autowired
    public void setPaymentRepository(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment makePayment(Payment payment) {
        payment.setTransactionId(UUID.randomUUID().toString());
        payment.setPaymentStatus(new Random().nextBoolean()? PaymentStatus.SUCCESS:PaymentStatus.FAILED);
        return paymentRepository.save(payment);
    }
}
