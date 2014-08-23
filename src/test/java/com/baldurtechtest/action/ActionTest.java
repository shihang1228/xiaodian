package com.baldurtech.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class ActionTest {
    
    @Test
        public void uri_contact_show_的显示页面应该是_jsp_contact_show() {
            ServletContext servletContext = mock(ServletContext.class);
            HttpServletRequest req = mock(HttpServletRequest.class);
            HttpServletResponse resp = mock(HttpServletResponse.class);
            Action action = new Action(servletContext, req, resp);
            assertEquals("/WEB-INF/jsp/contact/show.jsp", action.getViewPage("/contact/show.jsp"));
        }
}