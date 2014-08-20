package com.baldurtech;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

public class DispatchServlet extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse resp) 
                        throws IOException,ServletException
    {
        resp.getWriter().println("hello, " + req.getContextPath());
    }
    
    public String getClassByUri(String uri) {
        String[] uriParts = splitBySlash(uri);
        return capitalize(uriParts[1] + "Action");
    }
    
    public String[] splitBySlash(String uri) {
        String[] uriParts = uri.split("/");
        return uriParts;
    }
    
    public String capitalize(String str) {
        return str.substring(0,1).toUpperCase() + str.substring(1);
    }
}