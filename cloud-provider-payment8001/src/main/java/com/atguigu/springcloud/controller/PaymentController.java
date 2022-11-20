package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.service.PaymentService;
import com.atguigu.springcould.entities.CommonResult;
import com.atguigu.springcould.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * PaymentController
 *
 * @author fj
 * @date 2022/11/15 20:45
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;//导入cloud下的 而不是netflix

    @PostMapping("/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        int ret = paymentService.create(payment);
        log.info("插入成功");
        if (ret > 0) return new CommonResult<Payment>(200,"插入成功,serverPort"+serverPort,ret);
        else return new CommonResult<Payment>(444,"插入失败,serverPort"+serverPort);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment!=null) return new CommonResult<Payment>(200,"获取数据成功 serverPort"+serverPort,payment);
        else return new CommonResult<Payment>(444,"获取数据失败,serverPort"+serverPort);
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        //获取所有微服务
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service===> {}",service);
        }
        //获取微服务下的实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeOut()
    {
        System.out.println("*****paymentFeignTimeOut from port: "+serverPort);
        //暂停几秒钟线程
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        return serverPort;
    }
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB()
    {
        return serverPort;
    }

}
