package com.wllnb.wllblog.common.util;

import java.util.HashMap;

/**
 * MapUtils
 *
 * @author wllnb
 * @description Map工具类
 */
public class MapUtils extends HashMap<String,Object> {

    @Override
    public MapUtils put(String key, Object value) {
        super.put(key,value);
        return this;
    }
}
