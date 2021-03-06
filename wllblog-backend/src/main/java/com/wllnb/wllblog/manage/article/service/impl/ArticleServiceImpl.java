package com.wllnb.wllblog.manage.article.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wllnb.wllblog.common.enums.ModuleEnum;
import com.wllnb.wllblog.common.util.PageUtils;
import com.wllnb.wllblog.common.util.Query;
import com.wllnb.wllblog.entity.article.Article;
import com.wllnb.wllblog.entity.article.dto.ArticleDTO;
import com.wllnb.wllblog.entity.article.vo.ArticleVO;
import com.wllnb.wllblog.entity.operation.Category;
import com.wllnb.wllblog.manage.article.service.ArticleService;
import com.wllnb.wllblog.manage.operation.service.CategoryService;
import com.wllnb.wllblog.manage.operation.service.TagService;
import com.wllnb.wllblog.mapper.article.ArticleMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * articleAdminServiceImpl
 *
 * @author wllnb
 * @description
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Resource
    private TagService tagService;

    @Resource
    private CategoryService categoryService;

    /**
     * 分页查询博文列表
     *
     * @param params
     * @return
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ArticleVO> page = new Query<ArticleVO>(params).getPage();
        List<ArticleVO> articleList = baseMapper.listArticleVo(page, params);
        // 查询所有分类
        List<Category> categoryList = categoryService.list(new QueryWrapper<Category>().lambda().eq(Category::getType,ModuleEnum.ARTICLE.getValue()));
        // 封装ArticleVo
        Optional.ofNullable(articleList).ifPresent((articleVos ->
                articleVos.forEach(articleVo -> {
                // 设置类别
                articleVo.setCategoryListStr(categoryService.renderCategoryArr(articleVo.getCategoryId(),categoryList));
                // 设置标签列表
                articleVo.setTagList(tagService.listByLinkId(articleVo.getId(), ModuleEnum.ARTICLE.getValue()));
            })));
        page.setRecords(articleList);
        return new PageUtils(page);
    }



    /**
     * 保存博文文章
     *
     * @param article
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveArticle(ArticleDTO article) {
        baseMapper.insert(article);
        tagService.saveTagAndNew(article.getTagList(),article.getId(),ModuleEnum.ARTICLE.getValue());
    }

    /**
     * 更新博文
     *
     * @param article
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateArticle(ArticleDTO article) {
        // 删除多对多所属标签
        tagService.deleteTagLink(article.getId(),ModuleEnum.ARTICLE.getValue());
        // 更新所属标签
        tagService.saveTagAndNew(article.getTagList(),article.getId(), ModuleEnum.ARTICLE.getValue());
        // 更新博文
        baseMapper.updateById(article);
    }

    /**
     * 获取文章对象
     *
     * @param articleId
     * @return
     */
    @Override
    public ArticleDTO getArticle(Integer articleId) {
        ArticleDTO articleDto = new ArticleDTO();
        Article article = this.baseMapper.selectById(articleId);
        BeanUtils.copyProperties(article,articleDto);
        // 查询所属标签
        articleDto.setTagList(tagService.listByLinkId(articleId,ModuleEnum.ARTICLE.getValue()));
        return articleDto;
    }

    @Override
    public boolean checkByCategory(Integer categoryId) {
        return baseMapper.checkByCategory(categoryId) > 0;
    }

    /**
     * 批量删除
     *
     * @param articleIds
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBatch(Integer[] articleIds) {
        //先删除博文标签多对多关联
        Arrays.stream(articleIds).forEach(articleId -> {
            tagService.deleteTagLink(articleId,ModuleEnum.ARTICLE.getValue());
        });
        this.baseMapper.deleteBatchIds(Arrays.asList(articleIds));
    }


}
