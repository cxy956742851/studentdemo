package com.southsmart.smartweb.common.util;

import java.util.UUID;

public class StringUtil {
    /**
     * 判定字符串是否为空
     * 
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        if (str == null || "".equals(str))
            return true;
        return false;
    }
    
    /**
     * 生成uuid
     * 
     * @return
     */
    public static String getUUID() {
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        return uuid;
    }
}
