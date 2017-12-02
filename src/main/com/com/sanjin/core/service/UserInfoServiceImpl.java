package com.sanjin.core.service;

import com.sanjin.core.dao.UserInfoDao;
import com.sanjin.core.dao.UserInfoDaoImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UserInfoServiceImpl implements UserInfoService {
    private final static Logger logger = LogManager.getLogger(UserInfoServiceImpl.class);
    private UserInfoDao userInfoDao;
    public String getUerInfo() {
        logger.error("调用dao层！");
        userInfoDao = new UserInfoDaoImpl();
        List<Map<Integer,String>> lists = userInfoDao.getUserInfo();
        return null;
    }
}
