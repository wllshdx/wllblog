package com.wllnb.wllblog.portal.article.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.wllnb.wllblog.common.util.PageUtils;
import com.wllnb.wllblog.entity.article.Article;
import com.wllnb.wllblog.entity.article.vo.ArticleVO;

import java.util.Map;

/**
 * <p>
 * 文章 服务类
 * </p>
 *
 * @author wllnb
 */
public interface ArticleService extends IService<Article> {

    /**
     * 分页分类获取列表
     * @param params
     * @return
     */
    PageUtils queryPageCondition(Map<String, Object> params);

    /**
     * 获取ArticleVo对象
     * @param articleId
     * @return
     */
    ArticleVO getArticleVo(Integer articleId);

    /**
     * 获取简单的Article对象
     * @param articleId
     * @return
     */
     ArticleVO getSimpleArticleVo(Integer articleId);

}
