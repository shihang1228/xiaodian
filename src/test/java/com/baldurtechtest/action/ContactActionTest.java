package com.baldurtech.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;
import javax.servlet.RequestDispatcher;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import org.mockito.InOrder;

import com.baldurtech.domain.Contact;
import com.baldurtech.manager.ContactManager;
import java.util.HashMap;

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
    
   /* @Test
    public void 当id合法但对应的contact不存在返回对应的处理() {
        when(req.getParameter("id")).thenReturn("1");
        when(contactManager.show("1")).thenReturn(null);
                
        ContactAction spy = spy(contactAction);
        spy.show();
        verify(spy).flashMessage("Contact Not Found!");
    }
    */
    @Test
    public void 测试forwardAction能正确设置参数并跳转() throws Exception{
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        InOrder inOrder = inOrder(req, servletContext, dispatcher);
        when(servletContext.getRequestDispatcher("/contact/show.do")).thenReturn(dispatcher);
        
        contactAction.forwardAction("contact/show", new HashMap<String, Object>(){{put("name1", "xiaobaiOne"); put("name2", "xiaobaiTwo");}});
        
        inOrder.verify(req, times(1)).setAttribute("name1", "xiaobaiOne");
        inOrder.verify(req, times(1)).setAttribute("name2", "xiaobaiTwo");
        inOrder.verify(servletContext).getRequestDispatcher("/contact/show.do");
        inOrder.verify(dispatcher).forward(req, resp);
    }
}