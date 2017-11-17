package com.sanjin.frameWork.web.tag;

import com.sanjin.frameWork.content.ApplicationContext;

public class LinkUrlUtils {

    public static String getlInkUrl(String value){
        String baseUrl = ApplicationContext.getContextPath();
        String versionNum = ApplicationContext.getCurrentVersionNo();
        StringBuffer sb = new StringBuffer();
        sb.append(baseUrl).append(value);
        if(sb.indexOf("?") > -1){
            sb.append("&vn=").append(versionNum);
        }else{
            sb.append("?vn=").append(versionNum);
        }
        return sb.toString();
    }
}
