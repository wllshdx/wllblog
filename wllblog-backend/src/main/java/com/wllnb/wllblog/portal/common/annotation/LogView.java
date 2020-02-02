package com.wllnb.wllblog.portal.common.annotation;

import java.lang.annotation.*;

/**
 * ViewLog
 *
 * @author wllnb
 * @description
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogView {

     String type();
}
