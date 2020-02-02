package com.wllnb.wllblog.manage.operation.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wllnb.wllblog.common.util.PageUtils;
import com.wllnb.wllblog.common.util.Query;
import com.wllnb.wllblog.entity.operation.Tag;
import com.wllnb.wllblog.entity.operation.TagLink;
import com.wllnb.wllblog.manage.operation.service.TagService;
import com.wllnb.wllblog.mapper.operation.TagLinkMapper;
import com.wllnb.wllblog.mapper.operation.TagMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * <p>
 * 标签 服务实现类
 * </p>
 *
 * @author wllnb
 */
@Service
@Slf4j
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

    @Resource
    private TagLinkMapper tagLinkMapper;

    /**
     * 分页查询
     *
     * @param params
     * @return
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<Tag> page = baseMapper.selectPage(new Query<Tag>(params).getPage(),
                new QueryWrapper<Tag>().lambda());
        return new PageUtils(page);
    }

    /**
     * 根据关联Id获取列表
     *
     * @param linkId
     * @return
     */
    @Override
    public List<Tag> listByLinkId(Integer linkId, Integer type) {
        return this.baseMapper.listByLinkId(linkId, type);
    }

    /**
     * 添加所属标签，包含新增标签
     *
     * @param tagList
     * @param linkId
     */
    @Override
    public void saveTagAndNew(List<Tag> tagList, Integer linkId, Integer type) {
        Optional.ofNullable(tagList)
                .ifPresent(tagListValue -> tagListValue.forEach(tag -> {
                    if (tag.getId() == null) {
                        this.baseMapper.insert(tag);
                    }
                    TagLink tagLink = new TagLink(linkId, tag.getId(), type);
                    tagLinkMapper.insert(tagLink);
                }));
    }

    /**
     * 删除tagLink关联
     *
     * @param linkId
     */
    @Override
    public void deleteTagLink(Integer linkId, Integer type) {
        tagLinkMapper.delete(new QueryWrapper<TagLink>().lambda()
                .eq(linkId != null, TagLink::getLinkId, linkId)
                .eq(type != null, TagLink::getType, type));
    }


}
