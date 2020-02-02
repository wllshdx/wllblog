package com.wllnb.wllblog.manage.operation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wllnb.wllblog.common.util.PageUtils;
import com.wllnb.wllblog.entity.operation.Tag;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 标签 服务类
 * </p>
 *
 * @author wllnb
 */
public interface TagService extends IService<Tag> {

    /**
     * 分页查询
     *
     * @param params
     * @return
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 根据关联Id获取列表
     *
     * @param linkId
     * @param type
     * @return
     */
    List<Tag> listByLinkId(Integer linkId, Integer type);

    /**
     * 添加所属标签，包含新增标签
     *
     * @param tagList
     * @param linkId
     * @param type
     */
    void saveTagAndNew(List<Tag> tagList, Integer linkId, Integer type);

    /**
     * 删除tagLink关联
     * @param linkId
     * @param type
     */
    void deleteTagLink(Integer linkId, Integer type);


}
