package com.sanjin.frameWork.content;

import com.sanjin.frameWork.utils.StringUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.context.ApplicationContextException;
import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

public class ApplicationContext {

    private static org.springframework.context.ApplicationContext context;

    public static final String CONTEXT_CLASS   = "org.springframework.web.context.support.XmlWebApplicationContext";

    private static  String currentVersionNo;

    private static Properties commonConfigMap = new  Properties();

    private static String systemImgUrl;

    private static String realPath;

    private static boolean isMysql;

    private static boolean isOracle;

    protected static void initCommonConfig(ServletContext servletContext){
        InputStream is = null;
        realPath =  System.getProperty("sanJin.root");
        String filePath = realPath +"WEB-INF"+File.separator+"config"+File.separator+"common-config.properties";
        try {
            // is = ApplicationContext.class.getClassLoader().getResourceAsStream("/common-config.properties");
            is = new FileInputStream(filePath);
            commonConfigMap.load(is);
        } catch (IOException e) {
            throw new ApplicationContextException(
                    "Failed to load custom context class [" + CONTEXT_CLASS + "]", e);
        } finally {
            IOUtils.closeQuietly(is);
        }

        systemImgUrl = commonConfigMap.getProperty("system.img.url");
        if(StringUtils.isEmpty(systemImgUrl)){
            systemImgUrl = servletContext.getContextPath();
        }

        String defaultLocale = commonConfigMap.getProperty("system.defaultLocale");
        if (StringUtils.isEmpty(defaultLocale)) {
            defaultLocale = servletContext.getInitParameter("defaultLocale");
        }
        if (StringUtils.hasLength(defaultLocale,true)) {
            defaultLocale = defaultLocale.trim();
            if (defaultLocale.equals(Locale.CHINA.getLanguage())) {
                Locale.setDefault(Locale.CHINA);
            } else if (defaultLocale.equals(Locale.ENGLISH.getLanguage())) {
                Locale.setDefault(Locale.ENGLISH);
            }
        }

        // 更新版本号
        Date now = new Date();
        currentVersionNo = now.getTime() + "";

        String dataSourceUrl = commonConfigMap.getProperty("sanjin.dataSource.url");
        isMysql = dataSourceUrl.contains("mysql");
        isOracle = dataSourceUrl.contains("oracle");
    }

    public static String getSystemImgUrl() {
        return systemImgUrl;
    }

    public boolean isMysql() {
        return isMysql;
    }

    public boolean isOracle() {
        return isOracle;
    }

    public static String getCurrentVersionNo() {
        return currentVersionNo;
    }
}
