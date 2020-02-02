package com.wllnb.wllblog.manage.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wllnb.wllblog.common.util.PageUtils;
import com.wllnb.wllblog.entity.sys.SysParam;

import java.util.Map;

/**
 * <p>
 * 系统参数 服务类
 * </p>
 *
 * @author wllnb
 */
public interface SysParamService extends IService<SysParam> {

    /**
     * 分页查询
     * @param params
     * @return
     */
     PageUtils queryPage(Map<String, Object> params);
}
