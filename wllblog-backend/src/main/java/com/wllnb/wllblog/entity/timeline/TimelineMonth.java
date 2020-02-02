package com.wllnb.wllblog.entity.timeline;

import lombok.Data;

import java.util.List;

/**
 * TimeLineMonth
 *
 * @author wllnb
 * @description
 */
@Data
public class TimelineMonth {

    private Integer month;

    private Integer count;

    private List<TimelinePost> posts;

}
