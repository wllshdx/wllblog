package com.wllnb.wllblog.portal.operation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wllnb.wllblog.entity.operation.Link;
import com.wllnb.wllblog.mapper.operation.LinkMapper;
import com.wllnb.wllblog.portal.operation.service.LinkService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * LinkService
 *
 * @author wllnb
 * @description
 */
@Service("linkPortalService")
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {


    /**
     * 获取link列表
     *
     * @return
     */
    @Override
    public List<Link> listLink() {
        return baseMapper.selectList(null);
    }
}
