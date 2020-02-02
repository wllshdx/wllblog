package com.wllnb.wllblog.entity.book;

import com.wllnb.wllblog.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 读后感
 *
 * @author wllnb
 */
@Data
@ApiModel(value="ReadBookSense对象", description="读后感")
public class BookSense extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "作者")
    private String author;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "关联图书Id")
    private Integer bookId;



}
