package com.wllnb.wllblog.manage.operation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wllnb.wllblog.common.util.PageUtils;
import com.wllnb.wllblog.entity.operation.Recommend;
import com.wllnb.wllblog.entity.operation.vo.RecommendVO;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 推荐 服务类
 * </p>
 *
 * @author wllnb
 */
public interface RecommendService extends IService<Recommend> {

    /**
     * 分页查询
     * @param params
     * @return
     */
     PageUtils queryPage(Map<String, Object> params);

    /**
     * 获取推荐列表
     * @return
     */
    List<RecommendVO> listSelect();

    /**
     * 更新置顶状态
     * @param id
     */
    void updateTop(Integer id);

    /**
     * 批量删除
     * @param articleIds
     * @param value
     */
    void deleteBatchByLinkId(Integer[] articleIds, int value);
}
