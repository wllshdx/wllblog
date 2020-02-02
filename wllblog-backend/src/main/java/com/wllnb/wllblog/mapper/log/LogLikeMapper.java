package com.wllnb.wllblog.mapper.log;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wllnb.wllblog.entity.log.LogLike;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 阅读日志 Mapper 接口
 * </p>
 *
 * @author wllnb
 */
@Mapper
public interface LogLikeMapper extends BaseMapper<LogLike> {

}
