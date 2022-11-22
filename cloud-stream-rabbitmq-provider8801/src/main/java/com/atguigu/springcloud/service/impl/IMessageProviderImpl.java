package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * IMessageProviderImpl
 *
 * @author fj
 * @date 2022/11/21 20:03
 */
@Service
@EnableBinding(Source.class)//定义消息发送的管道
@Slf4j
public class IMessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String msg= UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(msg).build());
        log.info("******Message-->{}",msg);
        return msg;
    }

}
