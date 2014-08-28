package com.baldurtech.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

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
    public void 当调用index方法时重定向到contact_list() throws java.io.IOException{
        contactAction.index();
        
        verify(resp).sendRedirect("contact/list");
    }
    
}