package com.wllnb.wllblog.search.config;

import com.wllnb.wllblog.common.constants.RabbitMqConstants;
import com.wllnb.wllblog.common.util.RabbitMqUtils;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * InitialConfig
 *
 * @author wllnb
 * @description
 */
@Configuration
public class InitialConfig {

    @Resource
    private RabbitMqUtils rabbitMqUtils;

    /**
     * 项目启动时重新导入索引
     */
    @PostConstruct
    public void initEsIndex(){
        rabbitMqUtils.send(RabbitMqConstants.REFRESH_ES_INDEX_QUEUE,"wllblog-search init index");
    }
}
