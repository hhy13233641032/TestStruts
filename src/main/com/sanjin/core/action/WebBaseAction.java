package sanjin.core.action;

import com.opensymphony.xwork2.ActionSupport;

public class WebBaseAction extends ActionSupport{

    public String execute() throws Exception {
        return SUCCESS;
    }

    public String login(){
        return "login";
    }
}
