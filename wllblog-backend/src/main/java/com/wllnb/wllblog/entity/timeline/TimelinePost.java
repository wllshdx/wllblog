package com.wllnb.wllblog.entity.timeline;

import lombok.Data;

import java.util.Date;

/**
 * TimeLineData
 *
 * @author wllnb
 * @description
 */
@Data
public class TimelinePost {

    private Integer id;

    private String title;

    private String description;

    private String postType;

    private Date createTime;

}
