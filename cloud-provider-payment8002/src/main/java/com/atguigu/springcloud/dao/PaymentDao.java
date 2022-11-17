package com.atguigu.springcloud.dao;


import com.atguigu.springcould.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * PaymentDao
 *
 * @author fj
 * @date 2022/11/15 20:17
 */
@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
