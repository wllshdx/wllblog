package com.wllnb.wllblog.portal.operation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wllnb.wllblog.entity.operation.Tag;
import com.wllnb.wllblog.entity.operation.vo.TagVO;
import com.wllnb.wllblog.mapper.operation.TagMapper;
import com.wllnb.wllblog.portal.operation.service.TagService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TagServiceImpl
 *
 * @author wllnb
 * @description
 */
@Service("TagPortalService")
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {


    /**
     * 获取tagVoList
     *
     * @return
     */
    @Override
    public List<TagVO> listTagVo() {
        return baseMapper.listTagVo();
    }
}
