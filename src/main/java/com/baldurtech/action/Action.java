package com.baldurtech.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action {
    final ServletContext servletContext;
    final HttpServletRequest req;
    final HttpServletResponse resp;
    
    public Action(ServletContext servletContext, HttpServletRequest req, HttpServletResponse resp) {
        this.servletContext = servletContext;
        this.req = req;
        this.resp = resp;
    }
    
    public String getViewPage(String uri) {
        return "/WEB-INF/jsp" + uri;
    }
    
}