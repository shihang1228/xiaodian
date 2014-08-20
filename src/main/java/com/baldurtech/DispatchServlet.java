package com.baldurtech;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

public class DispatchServlet extends HttpServlet
{
    public void service(HttpServletRequest req, HttpServletResponse resp) 
                        throws IOException,ServletException
    {
        resp.getWriter().println("hello, " + req.getContextPath());
    }
}