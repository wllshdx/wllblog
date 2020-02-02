package com.wllnb.wllblog.manage.operation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wllnb.wllblog.common.util.PageUtils;
import com.wllnb.wllblog.entity.operation.Link;

import java.util.Map;

/**
 * <p>
 * 友链 服务类
 * </p>
 *
 * @author wllnb
 */
public interface LinkService extends IService<Link> {

    /**
     * 分页查询
     * @param params
     * @return
     */
     PageUtils queryPage(Map<String, Object> params);
}
