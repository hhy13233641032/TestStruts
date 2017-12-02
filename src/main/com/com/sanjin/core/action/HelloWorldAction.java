package com.sanjin.core.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;

import java.util.LinkedHashMap;
import java.util.Map;

public class HelloWorldAction extends ActionSupport{
    private static final Logger LOG = LogManager.getLogger(HelloWorldAction.class);

    private  String userName;
    private String userPassword;
    private String message;
    private static Map<String,String> userMaps = new LinkedHashMap<String, String>();
    public String execute() throws Exception {
        return SUCCESS;
    }
    static {
        userMaps.put("huhy","123456");
        userMaps.put("sanjin","123456");
    }

    public String login(){
        String result = "";
        if(StringUtils.hasLength(userName)){
            if(userMaps.containsKey(userName) && userPassword .equals(userMaps.get(userName))){
                result = SUCCESS;
            }else{
                result = ERROR;
                message = "密码不正确!";
            }
        }else{
            result = ERROR;
            message = "用户名不存在!";
        }
        return result;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
