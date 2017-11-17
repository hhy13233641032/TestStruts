package com.sanjin.frameWork.web.tag;

import com.sanjin.frameWork.content.ApplicationContext;

public class LinkUrlUtils {

    public static String getlInkUrl(String value){
        StringBuffer sb = new StringBuffer();
        String baseUrl = ApplicationContext.getSystemImgUrl();
        String versionNum = ApplicationContext.getCurrentVersionNo();
        sb.append(baseUrl).append(value);
        if(sb.indexOf("?") > -1){
            sb.append("&vn=").append(versionNum);
        }else{
            sb.append("?vn=").append(versionNum);
        }
        return sb.toString();
    }
}
