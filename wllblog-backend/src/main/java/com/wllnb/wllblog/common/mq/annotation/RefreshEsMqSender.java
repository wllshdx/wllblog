package com.wllnb.wllblog.common.mq.annotation;

import java.lang.annotation.*;

/**
 * RefreshEsMqSender
 *
 * @author wllnb
 * @description
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RefreshEsMqSender {
    String sender();

    String msg() default "send refresh msg to ElasticSearch";

}
