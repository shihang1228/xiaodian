package com.baldurtech.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Action {
    final ServletContext servletContext;
    final HttpServletRequest req;
    final HttpServletResponse resp;
    String contextPath;
    public Action(ServletContext servletContext, HttpServletRequest req, HttpServletResponse resp) {
        this.servletContext = servletContext;
        this.req = req;
        this.resp = resp;
        
        contextPath = req.getContextPath();
    }
    
    public abstract void index() throws java.io.IOException;
     
    public String toRealUri(String actionUri) {
        if(actionUri.indexOf("?") > 0) {
            return contextPath + "/" + actionUri.replace("?", ".do?");
        }
        return contextPath + "/" + actionUri +  ".do";
    } 
    
}