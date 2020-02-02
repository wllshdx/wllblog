package com.wllnb.wllblog.entity.sys.form;

import lombok.Data;

/**
 * SysLoginForm
 *
 * @author wllnb
 * @description 登录表单对象
 */
@Data
public class SysLoginForm {
    private String username;
    private String password;
    private String captcha;
    private String uuid;
}
