package com.wllnb.wllblog.portal.operation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wllnb.wllblog.entity.operation.Tag;
import com.wllnb.wllblog.entity.operation.vo.TagVO;

import java.util.List;

/**
 * TagService
 *
 * @author wllnb
 * @description
 */
public interface TagService extends IService<Tag> {

    /**
     * 获取tagVoList
     * @return
     */
    List<TagVO> listTagVo();
}
