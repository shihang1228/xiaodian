package com.baldurtech;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

public class DispatchServlet extends HttpServlet {
    static String suffix = ".do";

    public void service(HttpServletRequest req, HttpServletResponse resp) 
                        throws IOException,ServletException
    {
        resp.getWriter().println("hello, " + req.getContextPath());
    }
    
    public String getClassNameByUri(String uri) {
        Integer indexOfActionClassName = 1;
        String[] uriParts = splitBySlash(uri);
        return capitalize(removeSuffix(uriParts[indexOfActionClassName]) + "Action");
    }
    
    public String getMethodNameByUri(String uri){
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
}