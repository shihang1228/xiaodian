package com.baldurtech.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.io.IOException;

public class ContactActionTest {
    ContactAction contactAction;
    HttpServletRequest req;
    HttpServletResponse resp;
    ServletContext servletContext;
    
    @Before
    public void setUp() {
        req = mock(HttpServletRequest.class);
        resp = mock(HttpServletResponse.class);
        servletContext = mock(ServletContext.class);
        
        contactAction = new ContactAction(servletContext,req, resp);
    }
    
    @Test
    public void 当调用index方法时重定向到contact_list() throws IOException{
        contactAction.index();
        
        verify(resp).sendRedirect("contact/list");
    }
    
    @Test
    public void Uri_contact_show当id为null时应该跳转到list页面() throws IOException {
        when(req.getParameter("id")).thenReturn(null);
        
        contactAction.show();
        
        verify(resp).sendRedirect("contact/list");
    }
    
    @Test
    public void Uri_contact_show当id为blank时应该跳转到list页面() throws IOException {
        when(req.getParameter("id")).thenReturn("");
        
        contactAction.show();
        
        verify(resp).sendRedirect("contact/list");
    }
}