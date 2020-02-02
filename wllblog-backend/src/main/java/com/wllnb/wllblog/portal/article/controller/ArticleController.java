package com.wllnb.wllblog.portal.article.controller;


import com.wllnb.wllblog.common.Result;
import com.wllnb.wllblog.common.constants.RedisCacheNames;
import com.wllnb.wllblog.common.util.PageUtils;
import com.wllnb.wllblog.entity.article.vo.ArticleVO;
import com.wllnb.wllblog.portal.article.service.ArticleService;
import com.wllnb.wllblog.portal.common.annotation.LogLike;
import com.wllnb.wllblog.portal.common.annotation.LogView;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 文章 前端控制器
 * </p>
 *
 * @author wllnb
 */
@RestController("articlePortalController")
@CacheConfig(cacheNames = {RedisCacheNames.ARTICLE})
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @GetMapping("/article/{articleId}")
    @LogView(type = "article")
    public Result getArticle(@PathVariable Integer articleId){
        ArticleVO article = articleService.getArticleVo(articleId);
        return Result.ok().put("article",article);
    }

    @PutMapping("/article/like/{id}")
    @LogLike(type = "article")
    public Result likeArticle(@PathVariable Integer id) {
        return Result.ok();
    }

    @GetMapping("/articles")
    @Cacheable
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = articleService.queryPageCondition(params);
        return Result.ok().put("page",page);
    }


}
