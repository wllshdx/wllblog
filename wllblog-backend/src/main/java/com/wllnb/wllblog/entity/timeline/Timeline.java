package com.wllnb.wllblog.entity.timeline;

import lombok.Data;

import java.util.List;

/**
 * TimeLine
 *
 * @author wllnb
 * @description
 */
@Data
public class Timeline {

    private Integer year;

    private Integer count;

    private List<TimelineMonth> months;
}
