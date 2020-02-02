package com.wllnb.wllblog.portal.operation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wllnb.wllblog.entity.operation.Category;

import java.util.List;
import java.util.Map;

/**
 * CategoryService
 *
 * @author wllnb
 * @description
 */
public interface CategoryService extends IService<Category> {

    /**
     * 获取categoryList
     * @param params
     * @return
     */
    List<Category> listCategory(Map<String, Object> params);
}
