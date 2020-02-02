package com.wllnb.wllblog.portal.timeline.service;

import com.wllnb.wllblog.entity.timeline.Timeline;

import java.util.List;

/**
 * TimeLineService
 *
 * @author wllnb
 * @description
 */
public interface TimelineService {

    /**
     * 获取timeLine数据
     * @return
     */
    List<Timeline> listTimeLine();
}
