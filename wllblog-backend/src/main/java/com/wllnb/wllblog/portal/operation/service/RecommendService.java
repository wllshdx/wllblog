package com.wllnb.wllblog.portal.operation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wllnb.wllblog.entity.operation.Recommend;
import com.wllnb.wllblog.entity.operation.vo.RecommendVO;

import java.util.List;

/**
 * RecommendService
 *
 * @author wllnb
 * @description
 */
public interface RecommendService extends IService<Recommend> {

    List<RecommendVO> listRecommendVo();

    List<RecommendVO> listHotRead();
}
