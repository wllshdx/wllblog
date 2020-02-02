package com.wllnb.wllblog.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wllnb.wllblog.entity.sys.SysUserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * SysUserRoleMapper
 *
 * @author wllnb
 * @description
 */
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {
    /**
     * 查询roleId
     * @param userId
     * @return
     */
    List<Integer> queryRoleIdList(Integer userId);
}
