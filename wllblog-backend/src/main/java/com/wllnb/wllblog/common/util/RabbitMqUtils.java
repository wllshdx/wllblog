package com.wllnb.wllblog.common.util;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * RabbitMqUtils
 *
 * @author wllnb
 * @description
 */
@Component
public class RabbitMqUtils {

    @Resource
    private AmqpTemplate rabbitTemplate;

    /**
     * 发送到指定Queue
     * @param queueName
     * @param obj
     */
    public void send(String queueName, Object obj){
        this.rabbitTemplate.convertAndSend(queueName, obj);
    }
}
