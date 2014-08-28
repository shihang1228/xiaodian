package com.baldurtech.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;

import java.util.Map;
import java.util.HashMap;

import com.baldurtech.action.Action;
import com.baldurtech.template.JspTemplateEngine;

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
    
    /*@Test
    public void service方法应该根据uri调用对应方法() throws ServletException, IOException{
        String uri = "/xiaodian/contact/show.do";
        DispatchServlet spy = spy(servlet);
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        
        when(req.getRequestURI()).thenReturn(uri);
        when(spy.getClassNameByUri(anyString())).thenReturn("Contact");
        System.out.println(uri);
        spy.service(req, resp);
           
        verify(spy).service(req, resp);
        verify(spy).getClassNameByUri(uri);
        verify(spy).getMethodNameByUri(uri);   
    }
    */
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
        assertEquals("show", servlet.getMethodNameByUri("/contact/show.do"));
    }
    
    @Test
    public void uri_contact_do应该返回index方法() {
        assertEquals("index", servlet.getMethodNameByUri("/contact.do"));
    }
    
    @Test
    public void uri_contact_show_的显示页面应该是_jsp_contact_show() {
        ServletContext servletContext = mock(ServletContext.class);
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
   
        assertEquals("/WEB-INF/jsp/contact/show.jsp", servlet.getViewPage("/contact/show.do"));
    }
}