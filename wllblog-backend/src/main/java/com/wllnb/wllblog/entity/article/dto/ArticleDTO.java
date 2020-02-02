package com.wllnb.wllblog.entity.article.dto;

import com.wllnb.wllblog.entity.article.Article;
import com.wllnb.wllblog.entity.operation.Tag;
import lombok.Data;

import java.util.List;

/**
 * ArticleDto
 *
 * @author wllnb
 * @description
 */
@Data
public class ArticleDTO extends Article {

    private List<Tag> tagList;

}
