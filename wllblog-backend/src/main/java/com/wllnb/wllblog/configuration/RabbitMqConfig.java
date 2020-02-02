package com.wllnb.wllblog.configuration;

import com.wllnb.wllblog.common.constants.RabbitMqConstants;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * RabbitMQConfig
 *
 * @author wllnb
 * @description
 */
@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue queue() {
        return new Queue(RabbitMqConstants.REFRESH_ES_INDEX_QUEUE);
    }
}
