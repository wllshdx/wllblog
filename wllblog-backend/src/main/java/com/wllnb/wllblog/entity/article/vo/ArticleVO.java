package com.wllnb.wllblog.entity.article.vo;

import com.wllnb.wllblog.entity.article.Article;
import com.wllnb.wllblog.entity.operation.Tag;
import lombok.Data;

import java.util.List;

/**
 * ArticleVo
 *
 * @author wllnb
 * @description 文章列表VO
 */
@Data
public class ArticleVO extends Article {

    /**
     * 所属分类，以逗号分隔
     */
    private String categoryListStr;

    /**
     * 所属标签
     */
    private List<Tag> tagList;

}
