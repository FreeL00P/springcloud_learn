package com.atguigu.springcloud.controller;


import com.atguigu.springcould.entities.CommonResult;
import com.atguigu.springcould.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * OrderController
 *
 * @author fj
 * @date 2022/11/15 22:57
 */
@RestController
@Slf4j
public class OrderController {

    //public static final String PAYMENT_URL="http://127.0.0.1:8001";
    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/getPayment/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id ) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("/consumer/payment/discovery")
    public Object discovery(){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/discovery", Object.class);
    }



}
