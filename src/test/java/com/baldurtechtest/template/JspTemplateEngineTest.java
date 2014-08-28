package com.baldurtech.template;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Map;
import java.util.HashMap;

import com.baldurtech.servlet.DispatchServlet;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class JspTemplateEngineTest {
    JspTemplateEngine template;
    ServletContext servletContext;
    HttpServletRequest req;
    HttpServletResponse resp;
    
    @Before
    public void setup() {
        servletContext = mock(ServletContext.class);
        req = mock(HttpServletRequest.class);
        resp = mock(HttpServletResponse.class);
        
        template = new JspTemplateEngine(servletContext, req, resp);
    }
    
    @Test
    public void returnValue_为Map时应该循环设置属性() {
        String page = "WEB-INF/jsp/contact/show.jsp";
        Map<String, Object> returnValue = new HashMap<String, Object>(){{
            put("1", 1);
            put("2", 2);
        }};
        
        template.merge(page, returnValue);
        
        verify(req).setAttribute("1", 1);
        verify(req).setAttribute("2", 2);    
    }
   
    @Test
    public void returnValue_不是map且不为空时应该设置属性() {
        String page = "WEB-INF/jsp/contact/show.jsp";
        Object returnValue = new Object();
        
        template.merge(page, returnValue);
        
        verify(req).setAttribute("data", returnValue);    
    }
    
    @Test
    public void returnValue_为空时不应该设置属性() {
        String page = "WEB-INF/jsp/contact/show.jsp";
        Object returnValue = null;
        
        template.merge(page, returnValue);
        
        verify(req, never()).setAttribute(anyString(), anyObject());    
    }
}