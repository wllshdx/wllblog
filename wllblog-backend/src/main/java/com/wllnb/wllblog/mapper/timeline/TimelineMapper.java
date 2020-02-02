package com.wllnb.wllblog.mapper.timeline;

import com.wllnb.wllblog.entity.timeline.Timeline;
import com.wllnb.wllblog.entity.timeline.TimelinePost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * TimeLineMapper
 *
 * @author wllnb
 * @description
 */
@Mapper
public interface TimelineMapper {

    List<TimelinePost> listTimelinePost(@Param("year") Integer year, @Param("month") Integer month);

    List<Timeline> listTimeline();
}
