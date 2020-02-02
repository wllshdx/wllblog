package com.wllnb.wllblog.portal.operation.controller;

import com.wllnb.wllblog.common.Result;
import com.wllnb.wllblog.common.constants.RedisCacheNames;
import com.wllnb.wllblog.entity.operation.Link;
import com.wllnb.wllblog.portal.operation.service.LinkService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * LinkController
 *
 * @author wllnb
 * @description
 */
@RequestMapping("/operation")
@CacheConfig(cacheNames = RedisCacheNames.LINK)
@RestController("LinkPortalController")
public class LinkController {

    @Resource
    private LinkService linkService;

    @RequestMapping("/links")
    @Cacheable
    public Result listLink() {
        List<Link> linkList = linkService.listLink();
        return Result.ok().put("linkList",linkList);
    }
}
