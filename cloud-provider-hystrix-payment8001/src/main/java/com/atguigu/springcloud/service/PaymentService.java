package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * PaymentService
 *
 * @author fj
 * @date 2022/11/19 11:23
 */
@Service
public class PaymentService {

    /**
     * 正常访问模式
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id){
        return "线程池"+Thread.currentThread().getName() + "paymentInfo_OK,id"+id+"\t";
    }

    /**
     * 超时
     * 使用@HystrixCommand 配置服务降级
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
    })//配置服务降级 调用的方法 设置该线程超时时间 3s
    public String paymentInfo_TimeOut(Integer id) {
        int timeNumber = 5;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池" + Thread.currentThread().getName() + "paymentInfo_TimeOut,id" + id + "\t" + "耗时" + timeNumber + "秒钟 ";
    }

    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池" + Thread.currentThread().getName() + "paymentInfo_TimeOutHandler,id" + id + " 系统繁忙\t" + "(灬ꈍ ꈍ灬)";

    }
}
