package com.wllnb.wllblog.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wllnb.wllblog.entity.sys.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wllnb
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 查询所属角色
     * @param createUserId
     * @return
     */
    List<Integer> queryRoleIdList(Integer createUserId);
}
