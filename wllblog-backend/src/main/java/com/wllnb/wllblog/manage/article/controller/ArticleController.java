package com.wllnb.wllblog.manage.article.controller;

import com.wllnb.wllblog.common.Result;
import com.wllnb.wllblog.common.constants.RedisCacheNames;
import com.wllnb.wllblog.common.enums.ModuleEnum;
import com.wllnb.wllblog.common.mq.annotation.RefreshEsMqSender;
import com.wllnb.wllblog.common.util.PageUtils;
import com.wllnb.wllblog.common.validator.ValidatorUtils;
import com.wllnb.wllblog.entity.article.Article;
import com.wllnb.wllblog.entity.article.dto.ArticleDTO;
import com.wllnb.wllblog.manage.article.service.ArticleService;
import com.wllnb.wllblog.manage.operation.service.RecommendService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Set;


/**
 * ArticleAdminController
 *
 * @author wllnb
 * @description
 */
@RestController
@RequestMapping("/admin/article")
@CacheConfig(cacheNames ={RedisCacheNames.RECOMMEND,RedisCacheNames.TAG,RedisCacheNames.ARTICLE,RedisCacheNames.TIMELINE})
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @Resource
    private RecommendService recommendService;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @GetMapping("/list")
    @RequiresPermissions("article:list")
    public Result listArticle(@RequestParam Map<String, Object> params) {
        PageUtils page = articleService.queryPage(params);
        return Result.ok().put("page",page);
    }

    @GetMapping("/info/{articleId}")
    @RequiresPermissions("article:list")
    public Result info(@PathVariable Integer articleId) {
        ArticleDTO article = articleService.getArticle(articleId);
        return Result.ok().put("article",article);
    }

    @PostMapping("/save")
    @RequiresPermissions("article:save")
    @CacheEvict(allEntries = true)
    @RefreshEsMqSender(sender = "wllblog-manage-saveArticle")
    public Result saveArticle(@RequestBody ArticleDTO article){
        ValidatorUtils.validateEntity(article);
        articleService.saveArticle(article);
        return Result.ok();
    }

    @PutMapping("/update")
    @RequiresPermissions("article:update")
    @CacheEvict(allEntries = true)
    @RefreshEsMqSender(sender = "wllblog-manage-updateArticle")
    public Result updateArticle(@RequestBody ArticleDTO article){
        ValidatorUtils.validateEntity(article);
        articleService.updateArticle(article);
        return Result.ok();
    }

    @PutMapping("/update/status")
    @RequiresPermissions("article:update")
    @CacheEvict(allEntries = true)
    @RefreshEsMqSender(sender = "wllblog-manage-updateStatus")
    public Result updateStatus(@RequestBody Article article) {
        articleService.updateById(article);
        return Result.ok();
    }


    @DeleteMapping("/delete")
    @RequiresPermissions("article:delete")
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(allEntries = true)
    @RefreshEsMqSender(sender = "wllblog-manage-deleteArticle")
    public Result deleteBatch(@RequestBody Integer[] articleIds) {
        recommendService.deleteBatchByLinkId(articleIds, ModuleEnum.ARTICLE.getValue());
        articleService.deleteBatch(articleIds);
        return Result.ok();
    }

    @DeleteMapping("/cache/refresh")
    @RequiresPermissions("article:cache:refresh")
    public Result flush() {
        Set<String> keys = redisTemplate.keys(RedisCacheNames.PROFIX+"*");
        redisTemplate.delete(keys);
        return Result.ok();
    }

}
