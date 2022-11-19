package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * PaymentFallbackService
 *
 * @author fj
 * @date 2022/11/19 14:19
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentHystrixService fallback (灬ꈍ ꈍ灬)";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "paymentInfo_Timeout fallback (灬ꈍ ꈍ灬)";
    }
}
