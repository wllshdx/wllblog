package com.wllnb.wllblog.manage.operation.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wllnb.wllblog.entity.operation.Recommend;
import com.wllnb.wllblog.entity.operation.vo.RecommendVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 推荐 Mapper 接口
 * </p>
 *
 * @author wllnb
 */
@Mapper
public interface RecommendMapper extends BaseMapper<Recommend> {

    /**
     * 获取推荐文章列表
     * @return
     */
    List<RecommendVO> listSelect();

    /**
     * 获取推荐列表
     * @return
     */
    List<RecommendVO> listRecommendVo();

    /**
     * 获取最热列表
     * @return
     */
    List<RecommendVO> listHotRead();
}
