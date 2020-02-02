package com.wllnb.wllblog.manage.operation.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * BookNoteAdminController
 *
 * @author wllnb
 * @description
 */
@RestController
@RequestMapping("/admin/operation/redis")
public class RedisCacheController {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;


}
