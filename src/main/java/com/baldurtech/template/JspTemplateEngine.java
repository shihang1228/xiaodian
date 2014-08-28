package com.baldurtech.template;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baldurtech.action.Action;

import java.util.Map;

public class JspTemplateEngine implements TemplateEngine{
    ServletContext servletContext;
    HttpServletRequest req;
    HttpServletResponse resp;
    
    public JspTemplateEngine(ServletContext servletContext, HttpServletRequest req, HttpServletResponse resp) {
        this.servletContext = servletContext;
        this.req = req;
        this.resp = resp;
    }
    
    public void merge(String page, Object returnValue) {
        try{
            if(returnValue instanceof Map) {
                Map<String, Object> dataModel = (Map<String, Object>) returnValue;
                for(String key: dataModel.keySet()) {
                    req.setAttribute(key, dataModel.get(key));
                }
            }else {
                req.setAttribute("data", returnValue);
            }
            servletContext.getRequestDispatcher(page).forward(req, resp);
        } catch(Exception e) {
            
        }
    }
}