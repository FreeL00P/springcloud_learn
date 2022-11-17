package com.atguigu.springcloud.service;


import com.atguigu.springcould.entities.Payment;

/**
 * paymentService
 *
 * @author fj
 * @date 2022/11/15 20:40
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(Long id);
}
