package com.wllnb.wllblog.portal.timeline.controller;

import com.wllnb.wllblog.common.Result;
import com.wllnb.wllblog.entity.timeline.Timeline;
import com.wllnb.wllblog.portal.timeline.service.TimelineService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * TimeLineController
 *
 * @author wllnb
 * @description
 */
@RestController
@RequestMapping("/timeline")
public class TimelineController {

    @Resource
    private TimelineService timelineService;

    @GetMapping("")
    public Result listTimeline() {
        List<Timeline> timelineList = timelineService.listTimeLine();

        return Result.ok().put("timelineList",timelineList);
    }
}
