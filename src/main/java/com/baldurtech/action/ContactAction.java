package com.baldurtech.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baldurtech.domain.Contact;

import java.util.Map;
import java.io.IOException;

public class ContactAction extends Action{
    public ContactAction(ServletContext servletContext, HttpServletRequest req, HttpServletResponse resp) {
        super(servletContext, req, resp);
    }
    
    public Map<String, Object> list() {
        return null;
    }
    
    public void index() throws IOException {
        resp.sendRedirect("contact/list");
    }
    
    public Contact show() throws IOException {
        if(req.getParameter("id") == null || req.getParameter("id") == "") {
            resp.sendRedirect("contact/list");
            return null;
        }
        return null;
    }
}