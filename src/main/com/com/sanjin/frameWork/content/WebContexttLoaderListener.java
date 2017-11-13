package com.sanjin.frameWork.content;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class WebContexttLoaderListener implements ServletContextListener {

    private static final Log logger = LogFactory.getLog(WebContexttLoaderListener.class);

    public void contextInitialized(ServletContextEvent sce) {
        logger.debug("Loading XMLResourcesFactory");
        ApplicationContext.initCommonConfig(sce.getServletContext());
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }
}
