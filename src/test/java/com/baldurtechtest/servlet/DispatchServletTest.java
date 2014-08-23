package com.baldurtech.servlet;

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

public class DispatchServletTest{
    DispatchServlet servlet;
    
    @Before
    public void setup() {
        servlet =new DispatchServlet();
    }
    
    @Test
    public void service_只是一个测试() throws ServletException, IOException{
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        PrintWriter out = mock(PrintWriter.class);
        
        when(resp.getWriter()).thenReturn(out);
        when(req.getContextPath()).thenReturn("/xiaodian");
        
        servlet.service(req,resp);
        
        verify(out).println("hello, /xiaodian");
        
    }
    
    @Test
    public void uri_contact_show_do应该返回ContactAction() {
        assertEquals("ContactAction", servlet.getClassNameByUri("/contact/show.do"));
    }
    
    @Test 
    public void uri_contact_do也应该返回ContactAction() {
        assertEquals("ContactAction", servlet.getClassNameByUri("/contact.do"));
    }
    
    @Test
    public void uri_contact_show_do应该返回show方法() {
        assertEquals("show", servlet.getMethodNameByUri("/comtact/show.do"));
    }
    
    @Test
    public void uri_contact_do应该返回index方法() {
        assertEquals("index", servlet.getMethodNameByUri("/comtact.do"));
    }

    @Test
    public void uri_contact_show_的显示页面是_jsp_contact_show() {
        assertEquals("/WEB-INF/jsp/contact/show.jsp", servlet.getViewPage("/contact/show.jsp"));
    }
    
    
    
}