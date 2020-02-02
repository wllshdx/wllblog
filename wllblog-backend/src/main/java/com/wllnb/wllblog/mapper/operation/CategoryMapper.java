package com.wllnb.wllblog.mapper.operation;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wllnb.wllblog.entity.operation.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wllnb
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

    /**
     * 查询所有类别
     * @param params
     * @return
     */
    List<Category> queryAll(Map<String, Object> params);
}
