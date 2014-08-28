package com.baldurtech.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Map;

public class ContactAction extends Action{
    public ContactAction(ServletContext servletContext, HttpServletRequest req, HttpServletResponse resp) {
        super(servletContext, req, resp);
    }
    
    public Map<String, Object> list() {
        return null;
    }
    
    public void index() throws java.io.IOException {
        resp.sendRedirect("contact/list");
    }
}