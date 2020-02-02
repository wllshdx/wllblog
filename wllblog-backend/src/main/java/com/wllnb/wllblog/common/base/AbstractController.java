package com.wllnb.wllblog.common.base;

import com.wllnb.wllblog.entity.sys.SysUser;
import org.apache.shiro.SecurityUtils;

/**
 * AbstractController
 *
 * @author wllnb
 * @description
 */
public class AbstractController {

    protected SysUser getUser(){
        return (SysUser) SecurityUtils.getSubject().getPrincipal();
    }

    protected Integer getUserId(){
        return getUser().getUserId();
    }
}
