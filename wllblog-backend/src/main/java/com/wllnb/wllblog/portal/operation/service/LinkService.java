package com.wllnb.wllblog.portal.operation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wllnb.wllblog.entity.operation.Link;

import java.util.List;

/**
 * LinkService
 *
 * @author wllnb
 * @description
 */
public interface LinkService extends IService<Link> {

    /**
     * 获取link列表
     * @return
     */
    List<Link> listLink();
}
