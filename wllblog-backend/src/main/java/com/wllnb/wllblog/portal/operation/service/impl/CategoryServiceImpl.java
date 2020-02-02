package com.wllnb.wllblog.portal.operation.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wllnb.wllblog.entity.operation.Category;
import com.wllnb.wllblog.mapper.operation.CategoryMapper;
import com.wllnb.wllblog.portal.operation.service.CategoryService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * CategoryServiceImpl
 *
 * @author wllnb
 * @description
 */
@Service("categoryPortalService")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {


    /**
     * 获取categoryList
     *
     * @param params
     * @return
     */
    @Override
    public List<Category> listCategory(Map<String, Object> params) {
        String type = (String) params.get("type");
        String rank = (String) params.get("rank");
        return baseMapper.selectList(new QueryWrapper<Category>().lambda()
                .eq(StringUtils.isNotEmpty(type),Category::getType,type)
                .eq(StringUtils.isNotEmpty(rank),Category::getRank,rank));
    }
}
