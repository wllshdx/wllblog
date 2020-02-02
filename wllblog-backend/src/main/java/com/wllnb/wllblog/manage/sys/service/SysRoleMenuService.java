package com.wllnb.wllblog.manage.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wllnb.wllblog.entity.sys.SysRoleMenu;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wllnb
 */
@Service
public interface SysRoleMenuService extends IService<SysRoleMenu> {


    void saveOrUpdate(Integer roleId, List<Integer> menuIdList);

    List<Integer> queryMenuIdList(Integer roleId);

    void deleteBatchByRoleId(Integer[] roleIds);
}
