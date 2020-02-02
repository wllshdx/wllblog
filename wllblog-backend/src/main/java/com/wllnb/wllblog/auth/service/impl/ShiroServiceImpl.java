package com.wllnb.wllblog.auth.service.impl;


import com.wllnb.wllblog.auth.service.ShiroService;
import com.wllnb.wllblog.auth.service.SysUserTokenService;
import com.wllnb.wllblog.common.constants.RedisKeyConstants;
import com.wllnb.wllblog.common.constants.SysConstants;
import com.wllnb.wllblog.entity.sys.SysMenu;
import com.wllnb.wllblog.entity.sys.SysUser;
import com.wllnb.wllblog.entity.sys.SysUserToken;
import com.wllnb.wllblog.mapper.sys.SysMenuMapper;
import com.wllnb.wllblog.mapper.sys.SysUserMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * ShiroServiceImpl
 *
 * @author wllnb
 * @description Shiro Service实现类
 */
@Service
public class ShiroServiceImpl implements ShiroService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private SysMenuMapper sysMenuMapper;

    @Resource
    private SysUserTokenService sysUserTokenService;

    /**
     * 获取用户的所有权限
     *
     * @param userId
     * @return
     */
    @Override
    public Set<String> getUserPermissions(Integer userId) {
         List<String> permsList;

         //系统管理员，拥有最高权限
        if(SysConstants.SUPER_ADMIN.equals(userId)){
            List<SysMenu> menuList=sysMenuMapper.selectList(null);
            permsList=new ArrayList<>(menuList.size());
            menuList.forEach(menu ->  permsList.add(menu.getPerms()));
        }else {
            permsList = sysUserMapper.queryAllPerms(userId);
        }
        //返回用户权限列表
        return permsList.stream()
                // 过滤空置的字符串
                .filter(perms -> !StringUtils.isEmpty(perms))
                // 把小的list合并成大的list
                .flatMap(perms -> Arrays.stream(perms.split(",")))
                // 转换成set集合
                .collect(Collectors.toSet());
    }

    /**
     * 查询token
     *
     * @param token
     * @return
     */
    @Override
    public SysUserToken queryByToken(String token) {
        return sysUserTokenService.queryByToken(RedisKeyConstants.MANAGE_SYS_USER_TOKEN+token);
    }

    /**
     * 查询用户信息
     *
     * @param userId
     * @return
     */
    @Override
    public SysUser queryUser(Integer userId) {
        return sysUserMapper.selectById(userId);
    }

    /**
     * 续期
     *
     * @param userId
     * @param accessToken
     */
    @Override
    public void refreshToken(Integer userId, String accessToken) {
        sysUserTokenService.refreshToken(userId,accessToken);
    }
}
