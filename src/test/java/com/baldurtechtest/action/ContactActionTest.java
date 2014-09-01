package com.baldurtech.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import com.baldurtech.domain.Contact;
import com.baldurtech.manager.ContactManager;

import java.io.IOException;

public class ContactActionTest {
    ContactAction contactAction;
    ContactManager contactManager;
    HttpServletRequest req;
    HttpServletResponse resp;
    ServletContext servletContext;
    
    @Before
    public void setUp() {
        req = mock(HttpServletRequest.class);
        resp = mock(HttpServletResponse.class);
        servletContext = mock(ServletContext.class);
        contactManager = mock(ContactManager.class);
        when(req.getContextPath()).thenReturn("/xiaodian");
        
        contactAction = new ContactAction(servletContext,req, resp, contactManager);
        
    }
    
    @Test
    public void 当调用index方法时重定向到contact_list() throws IOException {
        contactAction.index();
       
        verify(resp).sendRedirect("/xiaodian/contact/list.do");
    }
    
    @Test
    public void Uri_contact_show当id为null时应该跳转到list页面() throws IOException {
        when(req.getParameter("id")).thenReturn(null);
    
        contactAction.show();
        
        verify(resp).sendRedirect("/xiaodian/contact/list.do");
    }
    
    @Test
    public void Uri_contact_show当id为blank时应该跳转到list页面() throws IOException  {
        when(req.getParameter("id")).thenReturn("");
        
        contactAction.show();
        
        verify(resp).sendRedirect("/xiaodian/contact/list.do");
    }
    
    @Test
    public void 当actionUri为contact_show返回绝对路径() {   
        assertEquals("/xiaodian/contact/show.do", contactAction.toRealUri("contact/show"));
    }
    
    
    @Test
    public void 当id合法且不为空时返回对应的处理() {   
        Contact contact = new Contact();
        contact.setId(1L);
        when(req.getParameter("id")).thenReturn("1");
        when(contactManager.show("1")).thenReturn(contact);
        
        assertEquals(contact, contactAction.show());
    }
}