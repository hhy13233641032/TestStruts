package com.sanjin.frameWork.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class StringUtils extends org.apache.commons.lang3.StringUtils {

    private static final Log logger   = LogFactory.getLog(StringUtils.class);

    public static boolean hasLength(StringBuilder s) {
        return s != null && s.length() > 0;
    }

    public static boolean hasLength(CharSequence s){
        return s != null && s.length() > 0;
    }

    public static boolean hasLength(CharSequence s,boolean isTrim){
        if (s == null || s.length() == 0) {
            return false;
        }
        if (isTrim) {
            String str = StringUtils.trim(s.toString());
            return str.length() > 0;
        } else {
            return true;
        }
    }
}
