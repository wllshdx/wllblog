package com.wllnb.wllblog.search.mapper;

import com.wllnb.wllblog.entity.article.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * ArticleRepository
 *
 * @author wllnb
 * @description
 */
@Component
public interface ArticleRepository extends ElasticsearchRepository<Article,Integer> {
}
