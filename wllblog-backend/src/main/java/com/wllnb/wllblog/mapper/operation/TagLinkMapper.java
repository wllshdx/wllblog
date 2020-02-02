package com.wllnb.wllblog.mapper.operation;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wllnb.wllblog.entity.operation.TagLink;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 文章标签多对多维护表 Mapper 接口
 * </p>
 *
 * @author wllnb
 */
@Mapper
public interface TagLinkMapper extends BaseMapper<TagLink> {

}
