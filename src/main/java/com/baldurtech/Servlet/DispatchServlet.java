package com.baldurtech.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.io.IOException;

import com.baldurtech.action.Action;
import com.baldurtech.template.JspTemplateEngine;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;

public class DispatchServlet extends HttpServlet {
    static String suffix = ".do";

    public void service(HttpServletRequest req, HttpServletResponse resp) 
                        throws IOException,ServletException
    {   
        try {
            String uri = req.getRequestURI().replace(req.getContextPath(), "");
            System.out.println(uri);
           
            Class actionClass = Class.forName(getClassNameByUri(uri));
            Constructor actionConstructor = actionClass.getDeclaredConstructor(ServletContext.class,
                                                    HttpServletRequest.class, HttpServletResponse.class);
            Action actionInstance = (Action) actionConstructor.newInstance(getServletContext(), req, resp);
            Method method = actionClass.getDeclaredMethod(getMethodNameByUri(uri));
            Object returnValue = method.invoke(actionInstance); 
            
            JspTemplateEngine template = new JspTemplateEngine(getServletContext(), req, resp);
            template.merge(getViewPage(uri), returnValue);
        } catch(Exception e) {
           
        }
    }
    
    public String getClassNameByUri(String uri) {
        System.out.println(uri);
        Integer indexOfActionClassName = 1;
        String[] uriParts = splitBySlash(uri);
        return capitalize(removeSuffix(uriParts[indexOfActionClassName]) + "Action");
    }
    
    public String getMethodNameByUri(String uri) {
        Integer indexOfActionMethodName = 2;
        String[] uriParts = splitBySlash(uri);
        if (uriParts.length <= indexOfActionMethodName){
            return "index";
        }
        return removeSuffix(splitBySlash(uri)[indexOfActionMethodName]);
    }
    
    
    public String[] splitBySlash(String uri) {
        String[] uriParts = uri.split("/");
        return uriParts;
    }
    
    public String capitalize(String str) {
        return str.substring(0,1).toUpperCase() + str.substring(1);
    }
    public String removeSuffix(String str) {
        return str.replace(suffix, "");
    }
    
    public String getViewPage(String uri) {
        return "/WEB-INF/jsp" + removeSuffix(uri) + ".jsp";
    }
}