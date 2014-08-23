package com.baldurtech.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContactAction extends Action{
    public ContactAction(ServletContext servletContext, HttpServletRequest req, HttpServletResponse resp) {
        super(servletContext, req, resp);
    }
       
}