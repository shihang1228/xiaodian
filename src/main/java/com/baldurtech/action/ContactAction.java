package com.baldurtech.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baldurtech.domain.Contact;
import com.baldurtech.manager.ContactManager;

import java.util.Map;
import java.io.IOException;

public class ContactAction extends Action{
    ContactManager contactManager;
    
    public ContactAction(ServletContext servletContext, HttpServletRequest req, HttpServletResponse resp) {
        this(servletContext, req, resp, new ContactManager());
    }
    
    public ContactAction(ServletContext servletContext, HttpServletRequest req,
                            HttpServletResponse resp, ContactManager contactManager) {
        super(servletContext, req, resp);
        this.contactManager = contactManager;
    }
   
    
    public Map<String, Object> list() {
        return null;
    }
    
    public void index() {
        try{
            resp.sendRedirect(toRealUri("contact/list"));
        }catch(IOException ie) {
            //ignore;
        }
    }
    
    public Contact show() {  
        if(req.getParameter("id") == null || req.getParameter("id") == "") {
            try {
                resp.sendRedirect(toRealUri("contact/list"));
            }catch (IOException ie) {
                //ignore;
            }
            return null;
        }
        return  contactManager.show(req.getParameter("id"));
    }
}