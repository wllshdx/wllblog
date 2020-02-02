package com.wllnb.wllblog.portal.operation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wllnb.wllblog.common.enums.ModuleEnum;
import com.wllnb.wllblog.entity.article.vo.ArticleVO;
import com.wllnb.wllblog.entity.book.vo.BookNoteVO;
import com.wllnb.wllblog.entity.operation.Recommend;
import com.wllnb.wllblog.entity.operation.vo.RecommendVO;
import com.wllnb.wllblog.manage.operation.mapper.RecommendMapper;
import com.wllnb.wllblog.portal.article.service.ArticleService;
import com.wllnb.wllblog.portal.book.service.BookNoteService;
import com.wllnb.wllblog.portal.operation.service.RecommendService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * RecommendServiceImpl
 *
 * @author wllnb
 * @description
 */
@Service("recommendPortalService")
public class RecommendServiceImpl extends ServiceImpl<RecommendMapper, Recommend> implements RecommendService {

    @Resource
    private ArticleService articleService;

    @Resource
    private BookNoteService bookNoteService;


    @Override
    public List<RecommendVO> listRecommendVo() {
        List<RecommendVO> recommendList =this.baseMapper.listRecommendVo();
        return genRecommendList(recommendList);
    }

    @Override
    public List<RecommendVO> listHotRead() {
        List<RecommendVO> hotReadList =this.baseMapper.listHotRead();
        genRecommendList(hotReadList);
        hotReadList.get(0).setTop(true);
        return hotReadList;
    }

    private List<RecommendVO> genRecommendList(List<RecommendVO> recommendList) {
        recommendList.forEach(recommendVo -> {
            if(ModuleEnum.ARTICLE.getValue() == recommendVo.getType()){
                ArticleVO simpleArticleVo = articleService.getSimpleArticleVo(recommendVo.getLinkId());
                BeanUtils.copyProperties(simpleArticleVo,recommendVo);
                recommendVo.setUrlType("article");
            }else if(ModuleEnum.BOOK_NOTE.getValue() == recommendVo.getType()) {
                BookNoteVO simpleBookNoteVo = bookNoteService.getSimpleBookNoteVo(recommendVo.getLinkId());
                recommendVo.setUrlType("bookNote");
                BeanUtils.copyProperties(simpleBookNoteVo,recommendVo);
            }
        });
        return recommendList;
    }
}
