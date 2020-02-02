package com.wllnb.wllblog.mapper.operation;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wllnb.wllblog.entity.operation.Tag;
import com.wllnb.wllblog.entity.operation.vo.TagVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 标签 Mapper 接口
 * </p>
 *
 * @author wllnb
 */
@Mapper
public interface TagMapper extends BaseMapper<Tag> {

    /**
     * 根据linkId获取Tag列表
     * @param linkId
     * @param type
     * @return
     */
    List<Tag> listByLinkId(@Param("linkId") Integer linkId, @Param("type") Integer type);

    /**
     * 根据linkId删除多对多关联
     * @param linkId
     * @param type
     */
    void deleteTagLink(@Param("linkId") Integer linkId, @Param("type") Integer type);

    /**
     * 获取tagVoList
     * @return
     */
    List<TagVO> listTagVo();
}
