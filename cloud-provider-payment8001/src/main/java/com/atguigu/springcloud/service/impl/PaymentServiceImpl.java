package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PaymentDao;

import com.atguigu.springcloud.service.PaymentService;
import com.atguigu.springcould.entities.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * PaymentServiceImpl
 *
 * @author fj
 * @date 2022/11/15 20:40
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }
}
