package com.baldurtech;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import java.io.PrintWriter;
import java.io.IOException;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class DispatchServletTest
{
    @Test
    public void service_ֻ��һ������() throws ServletException, IOException
    {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        PrintWriter out = mock(PrintWriter.class);
        
        when(resp.getWriter()).thenReturn(out);
        when(req.getContextPath()).thenReturn("/xiaodian");
        
        DispatchServlet servlet = new DispatchServlet();
        servlet.service(req,resp);
        
        verify(out).println("hello, /xiaodian");
        
    }
}